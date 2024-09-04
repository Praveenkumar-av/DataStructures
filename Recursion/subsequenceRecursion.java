// program to print all the possible sub suquence

import java.util.ArrayList;

class subsequenceRecursion{
    static void subsequence(int[] arr, ArrayList<Integer> arl, int i){
        if(i == arr.length){
            // int n = arl.size();
            // for(int j=0; j<n; j++)
            //     System.out.print(arl.get(j)+" ");
            System.out.println(arl);
            return;
        }

        // pick, include the current element in the arraylist
        arl.add(arr[i]);
        subsequence(arr, arl, i+1);
        arl.removeLast();

        // not pick, ignore the current element and proceed the next element in the arraylist
        subsequence(arr, arl, i+1);
    }

    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 3};

        ArrayList<Integer> arl = new ArrayList<>();
        subsequence(arr, arl, 0);
    }
}