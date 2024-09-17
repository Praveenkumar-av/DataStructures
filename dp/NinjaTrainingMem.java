// ANinja has an ‘N’ Day training schedule. He has to perform one of these three activities 
// (Running, Fighting Practice, or Learning New Moves) each day. There are merit points associated 
// with performing an activity each day. The same activity can’t be performed on two consecutive days.
// We need to find the maximum merit points the ninja can attain in N Days.

import java.util.Arrays;
class NinjaTrainingMem{
    static int maxTraining(int[][] points, int day, int last, int[][] dp){
        if(day == 0){
            int max = 0;
            for(int i=0; i<3; i++)
                if(i != last)
                    max = Math.max(max, points[day][i]);

            return dp[day][last] = max;
        }
        // if the day is not zero
        // check if it is already visited
        if(dp[day][last] != -1)
            return dp[day][last];

        int max = 0;
        for(int i=0; i<3; i++){
            if(i != last){
                int point = points[day][i]+maxTraining(points, day-1, i, dp);
                max = Math.max(point, max);
            }
        }
        return dp[day][last] = max;
    }   

    public static void main(String[] args){
        int[][] points = {{10, 40, 70},
                          {20, 50, 80},
                          {30, 60, 90},
                          {20, 30, 80},
                          {10, 50, 20}};

        int n = points.length;
        int[][] dp = new int[n][3];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);

        System.out.println("maximum points :"+maxTraining(points, n-1, 0, dp));
    }
}