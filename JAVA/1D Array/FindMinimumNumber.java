// Find the minimum element in an array.

import java.util.*;

public class FindMinimumNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.print("Enter numbers:");
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }

        int min = arr[0];

        for(int i = 1; i < size; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }

        System.out.println("Minimum number is " + min);
        sc.close();
    }
}