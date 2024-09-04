import java.util.ArrayList;
class SubSequenceSumOnce{
    static boolean printSubSequenceSum(int[] arr, ArrayList<Integer> arl, int sum, int s, int i){
        if(i == arr.length){
            if(sum == s){
                System.out.println(arl);
                return true;
            }
            return false;
        }

        s += arr[i];
        arl.add(arr[i]);
        if(printSubSequenceSum(arr, arl, sum, s, i+1))
            return true;
        arl.removeLast();
        s -= arr[i];

        if(printSubSequenceSum(arr, arl, sum, s, i+1)) 
            return true;

        return false;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 1};
        int sum = 3;
        ArrayList<Integer> arl = new ArrayList<>();
        printSubSequenceSum(arr, arl, sum, 0, 0);
    }
}