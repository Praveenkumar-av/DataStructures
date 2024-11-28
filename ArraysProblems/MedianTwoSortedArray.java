// Median of 2 Sorted Arrays of Different Sizes

class MedianTwoSortedArray {
    static double medianOfSortedArrays(int a[], int b[]) {
        int n = a.length, m = b.length;

        if (n > m) {
            return medianOfSortedArrays(b, a);
        }

        int low = 0, high = n;
        int left = (n + m + 1) / 2;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE;
            int l2 = Integer.MIN_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 - 1 >= 0) {
                l1 = a[mid1 - 1];
            }
            if (mid1 < n) {
                r1 = a[mid1];
            }
            if (mid2 - 1 >= 0) {
                l2 = b[mid2 - 1];
            }
            if (mid2 < m) {
                r2 = b[mid2];
            }

            if (l1 <= r2 && l2 <= r1) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }

                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};

        System.out.println(medianOfSortedArrays(a, b));
    }
}
