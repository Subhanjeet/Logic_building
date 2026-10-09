// Find Maximum Element in Array

import java.util.*;
public class FindMaximumNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.print("Enter elements: ");
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }

        int max = arr[0];
        for(int i=1; i<size;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }

            System.out.println("Maximum number is "+max);
        sc.close();
    }
}
