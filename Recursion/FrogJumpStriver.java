// There is a frog on the '1st' step of an 'N' stairs long staircase. 
// The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of 
// the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy 
// lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). 
// If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or 
// to '(i+2)th' stair. Your task is to find the minimum total energy used by 
// the frog to reach from '1st' stair to 'Nth' stair.

class FrogJumpStriver{
    static int findMinHeight(int[] height){
        int prev=0, prev2=0;
        prev = Math.abs(height[1]-height[0]);
    
        for(int i=2; i<height.length; i++){
            int jump1 = Math.abs(height[i]-height[i-1])+prev;
            int jump2 = Math.abs(height[i]-height[i-2])+prev2;

            prev2 = prev;
            prev = Math.min(jump1, jump2);
        }

        return prev;
    }

    public static void main(String[] args){
        int[] heights = new int[]{10, 20, 30, 10};

        System.out.println(findMinHeight(heights));
    }
}