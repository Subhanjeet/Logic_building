// Take an array of names as input from the user and print them on the screen.

import java.util.*;
public class userInput2 {
    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int num = sc.nextInt();
        sc.nextLine();

        String names[] = new String[num];

        for(int i = 0; i < num; i++){
            System.out.print("Enter "+(i+1)+" name: ");
            names[i] = sc.nextLine();
        }

        for(int i = 0; i < num; i++){
            System.out.println("Names enterded :"+names[i] );
        }
        sc.close();
    }
}
