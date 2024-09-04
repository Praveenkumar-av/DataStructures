class NinjaTraining{
    static int count = 0;
    static int maxTraining(int[][] points, int day, int last){
        count++;
        if(day == 0){
            int max = 0;
            for(int i=0; i<3; i++)
                if(i != last)
                    max = Math.max(max, points[day][i]);
            return max;
        }
        int max = 0;
        for(int i=0; i<3; i++){
            if(i != last){
                int point = points[day][i]+maxTraining(points, day-1, i);
                max = Math.max(point, max);
            }
        }
        
        return max;
    }   

    public static void main(String[] args){
        int[][] points = {{10, 40, 70},
                          {20, 50, 80},
                          {30, 60, 90},
                          {20, 30, 80},
                          {10, 50, 20}};

        int n = points.length;

        System.out.println("maximum points :"+maxTraining(points, n-1, 4));
        System.out.println("No. of steps :"+count);
    }
}