// print the number given by user

import java.util.*;
public class UserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        int number[] = new int[num];

        for(int i = 0; i< num ; i++){
            System.out.println("Enter "+(i+1)+" number : ");
            number[i] = sc.nextInt();
        }
        for(int i = 0; i < num ; i++){
            System.out.println("You entered : "+number[i]);
        }
        sc.close();
    }
}