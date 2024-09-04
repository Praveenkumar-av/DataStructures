// program to reverse the array using recursion

class ReverseArray{
    static void reverse(int i, int[] arr){
        if(i >= (int)arr.length/2) return;

        swap(arr, i, arr.length-i-1);
        reverse(i+1, arr);
    }

    static void swap(int[] arr, int i, int j){
        // swap the elements
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public static void main(String[] args){
        int arr[] = new int[]{1, 2, 3, 4, 5};

        reverse(0, arr);
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
    }
}