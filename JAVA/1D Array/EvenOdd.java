// Take input from user and Count Even and Odd Numbers

import java.util.*;
public class EvenOdd {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.print("Enter numbers: ");
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }

        int even = 0;
        int odd = 0;

        for(int i=0; i<size; i++){
            if(arr[i] % 2 == 0){
                even++;
            }
            else{
                odd++;
            }
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}
