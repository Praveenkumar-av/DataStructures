// House Robber problem with memoization
import java.util.Arrays;

class HouseRobberMem{
    static int max(int[] arr, int i, int[] mem){
        if(i == 0)
            return arr[0];
        else if(i < 0)
            return 0;

        if(mem[i] != -1) return mem[i];
        
        int pick = arr[i] + max(arr, i-2, mem);

        int notPick = max(arr, i-1, mem);

        return mem[i] = Math.max(pick, notPick);
    }

    public static void main(String[] args){
        int[] arr = new int[]{2, 1, 1, 2};
        int[] mem = new int[arr.length+1];
        Arrays.fill(mem, -1);

        System.out.println(max(arr, arr.length-1, mem));
    }
}