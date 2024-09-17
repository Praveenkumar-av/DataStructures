// ANinja has an ‘N’ Day training schedule. He has to perform one of these three activities 
// (Running, Fighting Practice, or Learning New Moves) each day. There are merit points associated 
// with performing an activity each day. The same activity can’t be performed on two consecutive days.
// We need to find the maximum merit points the ninja can attain in N Days.

class NinjaTrainingOptimal{
    static int maxTraining(int[][] points){
        int[] prevDay = new int[3];

        // Approach 1
        prevDay[0] = points[0][0];
        prevDay[1] = points[0][1];
        prevDay[2] = points[0][2];

        for(int day=1; day<points.length; day++){
            int[] temp = new int[3];
            // interate through each task of current day
            for(int last = 0; last<3; last++){
                // find the maximum task in the previous day without last
                int max = 0;
                for(int task = 0; task<3; task++)
                    if(task != last)
                        max = Math.max(max, prevDay[task]);
                
                // assign the maximum task to the temp array
                temp[last] = points[day][last]+max;
            }
            // update the maximum task of the current day
            prevDay = temp;
        }

        /* Approach 2

        prevDay[0] = Math.max(points[0][1], points[0][2]);
        prevDay[1] = Math.max(points[0][0], points[0][2]);
        prevDay[2] = Math.max(points[0][0], points[0][1]);

        for(int day=1; day<points.length; day++){
            int[] temp = new int[3];
            for(int last = 0; last<3; last++){
                temp[last] = 0;
                for(int task=0; task<3; task++){
                    if(task != last){
                        temp[last] = Math.max(temp[last], points[day][task]+prevDay[task]);
                    }
                }
            }

            prevDay = temp;
        }
        */

        // return the maximum value in the maximum task array
        return Math.max(prevDay[0], Math.max(prevDay[1], prevDay[2]));
    }

    public static void main(String[] args){
        int[][] points =  {{10, 40, 70},
                          {20, 50, 80},
                          {30, 60, 90},
                          {20, 30, 80},
                          {10, 50, 20}};

        int n = points.length;

        System.out.println("max points :"+maxTraining(points));
    }
}