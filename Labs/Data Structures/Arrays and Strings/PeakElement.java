public class PeakElement {
    static int findPeak(int[] arr, int low, int high, int n) {
        int mid = (low + high) / 2;
        if ((mid == 0 || arr[mid - 1] <= arr[mid]) &&
            (mid == n - 1 || arr[mid + 1] <= arr[mid]))
            return mid;
        if (mid > 0 && arr[mid - 1] > arr[mid])
            return findPeak(arr, low, mid - 1, n);
        else
            return findPeak(arr, mid + 1, high, n);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int index = findPeak(arr, 0, arr.length - 1, arr.length);
        System.out.println("Peak Element Index: " + index);
    }
}
