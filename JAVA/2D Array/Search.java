// Take a matrix as input from the user. Search for a given number x and print the indices at which it occurs


import java.util.*;
public class Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //matrix creation
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();

        int[][] matrix = new int[rows][columns];

        //input from user
        System.out.println("Enter the matrix elements: ");
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        //For search
        int x;
        System.out.print("Enter a number for search: ");
        x = sc.nextInt();

        //print output

        boolean found = false;

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if( x==matrix[i][j]){
                    System.out.println("Found at row("+(i+1)+"), and column("+(j+1)+")");
                    found = true;
                    break;
                }
            }
        }
        if(!found) {
            System.out.println("Element not found");
        }
        sc.close();
    }
}
