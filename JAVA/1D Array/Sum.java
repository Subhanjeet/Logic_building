//Take an array of integers as input and print the sum of all elements.

import java.util.*;
public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int num[] = new int[n];
        System.out.print("Enter "+n+" numbers: ");
        for(int i = 0; i<n; i++){
            num[i]= sc.nextInt();
        }

        int sum = 0;
        for(int i=0; i<n; i++){
            sum = sum + num[i];
        }
        System.out.println("Sum: " + sum);
        sc.close();
    }
}

