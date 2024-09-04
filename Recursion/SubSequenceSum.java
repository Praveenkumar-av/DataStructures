// program to print the subsequence that make up the given sum

import java.util.ArrayList;
class SubSequenceSum{
    static void printSubSequenceSum(int[] arr, ArrayList<Integer> arl, int sum, int s, int i){
        if(i == arr.length){
            if(sum == s)
                System.out.println(arl);

            return;
        }

        s += arr[i];
        arl.add(arr[i]);
        printSubSequenceSum(arr, arl, sum, s, i+1);
        arl.removeLast();
        s -= arr[i];

        printSubSequenceSum(arr, arl, sum, s, i+1);
    }

    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 1};
        int sum = 2;
        ArrayList<Integer> arl = new ArrayList<>();
        printSubSequenceSum(arr, arl, sum, 0, 0);
    }
}