import java.util.*;

class MaxMin {
    int max;
    int min;

    // Constructor
    MaxMin(int min, int max) {
        this.min = min;
        this.max = max;
    }

    // Divide and Conquer function
    public static MaxMin findMinMax(int arr[], int low, int high) {
        if (low == high) {
            return new MaxMin(arr[low], arr[low]);
        }

        if (high == low + 1) {
            if (arr[low] < arr[high])
                return new MaxMin(arr[low], arr[high]);
            else
                return new MaxMin(arr[high], arr[low]);
        }

        int mid = (low + high) / 2;

        MaxMin left = findMinMax(arr, low, mid);
        MaxMin right = findMinMax(arr, mid + 1, high);

        int overallMin = Math.min(left.min, right.min);
        int overallMax = Math.max(left.max, right.max);

        return new MaxMin(overallMin, overallMax);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter elements in array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        MaxMin result = findMinMax(arr, 0, n - 1);
        System.out.println("Minimum element: " + result.min);
        System.out.println("Maximum element: " + result.max);
    }
}
