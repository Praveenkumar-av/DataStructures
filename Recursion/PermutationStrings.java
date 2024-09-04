class PermuatationStrings {
    public List<String> find_permutation(String S) {
        List<String> l = new ArrayList<>();
        
        // sort the string 
        char[] temp = S.toCharArray();
        Arrays.sort(temp);
        S = new String(temp);
        
        // create a array for storing the visited characters
        boolean[] used = new boolean[S.length()];
        Arrays.fill(used, false);
        find(l, S, used, 0, S.length(), "");
        return l;
    }
    
    static void find(List<String> l, String S, boolean[] used, int count, int n, String str){
        if(count == n){
            if(!l.contains(str))
                l.add(str);
            return;
        }
            
        
        for(int i=0; i<n; i++){
            if(!used[i]){
                boolean[] newUsed = used.clone();
                newUsed[i] = true;
                find(l, S, newUsed, count+1, n, str+S.charAt(i));
            }
        }  
    }

    public static void main(String[] args){
        
    }
}