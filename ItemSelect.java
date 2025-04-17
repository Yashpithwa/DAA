import java.util.*;

class Activity {
    int start, end;

    Activity(int s, int e) {
        this.start = s;
        this.end = e;
    }
}

public class ItemSelect {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of activities:");
        int n = sc.nextInt();

        Activity arr[] = new Activity[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter start time of activity " + (i + 1) + ":");
            int start = sc.nextInt();
            System.out.println("Enter end time of activity " + (i + 1) + ":");
            int end = sc.nextInt();
            arr[i] = new Activity(start, end);
        }

        // Simple sort based on end time
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i].end > arr[j].end) {
                    Activity temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // Select activities
        System.out.println("\nSelected Activities:");
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i].start >= last) {
                System.out.println("[" + arr[i].start + ", " + arr[i].end + "]");
                last = arr[i].end;
            }
        }

        sc.close();
    }
}
