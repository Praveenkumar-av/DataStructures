class CountNoHopsTabulation{
    static int noHops(int n){
        // create array of size of size n+1
        int[] tab = new int[n+1];
        tab[0] = 1;
        tab[1] = 1;
        tab[2] = 2;

        for(int i=3; i<=n; i++)
            tab[i] = tab[i-1]+tab[i-2]+tab[i-3];

        return tab[n];
    }

    static int noHopsOptimal(int n){
        // create array of size 3
        int[] val = new int[3];
        val[0] = 1;
        val[1] = 1;
        val[2] = 2;

        for(int i=3; i<=n; i++)
            val[i%3] = val[(i-1)%3]+val[(i-2)%3]+val[(i-3)%3];

        return val[n%3];
    }

    public static void main(String[] args){
        int n = 10;

        System.out.println("No. of ways : "+noHops(n));
        System.out.println("No. of ways : "+noHopsOptimal(n));
    }
}