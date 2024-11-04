
import java.util.*;

class CombinationSum {

    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    static void findComb(int sum, ArrayList<Integer> temp, ArrayList<Integer> arr, int ind,
            ArrayList<ArrayList<Integer>> result) {
        if (ind < 0 || sum < 0) {
            return;
        }
        if (sum == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        temp.add(arr.get(ind));
        findComb(sum - arr.get(ind), temp, arr, ind, result);
        temp.remove(arr.get(ind));

        findComb(sum, temp, arr, ind - 1, result);
    }

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        // sort the arrayList in descending order
        Collections.sort(A, (o1, o2) -> o2 - o1);
        // remove duplicates
        ArrayList<Integer> arr = new ArrayList<>();
        int n = A.size();
        arr.add(A.get(0));
        for (int i = 1; i < n; i++) {
            if (!Objects.equals(A.get(i), A.get(i - 1))) {
                arr.add(A.get(i));
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        findComb(B, temp, arr, arr.size() - 1, result);

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arl = new ArrayList<>(List.of(7, 2, 6, 5));

        int B = 16;

        ArrayList<ArrayList<Integer>> result = combinationSum(arl, B);
        for (var l : result) {
            for (var e : l) {
                System.out.print(e + " ");
            }
            System.out.println("");
        }
    }
}
