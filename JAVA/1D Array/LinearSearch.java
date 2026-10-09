// Linear Search

import java.util.*;

public class LinearSearch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter elements:");
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int search = sc.nextInt();

        boolean found = false;

        for(int i = 0; i < size; i++){
            if(arr[i] == search){
                System.out.println("Element found at index " + i);
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("Element not found");
        }
        sc.close();
    }
}