// Count how many times a given number appears in the array.

import java.util.*;
public class FrequencyOfAnElement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.print("Enter elements: ");
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter number to check frequency: ");
        int check = sc.nextInt();
        int count = 0;

        for(int i=0; i<size; i++){
            if(arr[i] == check){
                count++;
            }
        }
            System.out.println("Frequency: "+count);
        sc.close();
    }
}
