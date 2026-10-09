// Reverse an Array

import java.util.*;
public class ReverseAnArray {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.print("Enter elements: ");
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = size-1;

        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        System.out.println("Reversed Array: "+Arrays.toString(arr));
        sc.close();
    }
}
