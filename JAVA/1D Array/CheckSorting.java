//Check whether array is sorted in increasing order.
import java.util.*;
public class CheckSorting {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter size: ");
            int size = sc.nextInt();

            if (size <= 1) {
                System.out.println("Sorted");
                return;
            }

            int[] arr = new int[size];

            System.out.print("Enter array elements: ");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            boolean isSorted = true;

            for (int i = 0; i < size - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    break;
                }
            }

            if (isSorted) {
                System.out.println("Sorted");
            } else {
                System.out.println("Not Sorted");
            }
        }
    }
}