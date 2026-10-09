//Take an array as input from the user. search for a given number x and print the index at which it occurs.

import java.util.*;
public class SearchAndPrint {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int size = sc.nextInt();

        int num[] = new int[size];

        for(int i =0; i<size; i++){
            System.out.print("Enter "+(i+1)+" number: ");
            num[i] = sc.nextInt();
        }

        System.out.println("Enter a number to find its index number: ");
        int index = sc.nextInt();

        for(int i=0; i<size; i++){
            if(num[i]==index){
                System.out.println(num[i] + " is found at index -> " + i);
            }else{
                System.out.println(index + " is not at index " + i + " -> " + num[i]);
            }
        }
     sc.close();
    }
}
