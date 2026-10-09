// Find the second largest number in the array

import java.util.*;
public class FindSecondLargestNumber {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size: ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.print("Enter elements: ");
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i = 0; i < size; i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }else if(arr[i] > secondLargest && arr[i]!= largest ){
                secondLargest = arr[i];
            }
        }
            if(secondLargest == Integer.MIN_VALUE){
                System.out.println("No second largest found");
            }else{
                System.out.println("Second largest is: "+secondLargest);
            }
            sc.close();
    }
}
