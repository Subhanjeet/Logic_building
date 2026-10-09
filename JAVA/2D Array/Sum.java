// Find total sum of all elements in 2D array.

import java.util.*;
public class Sum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Row column input
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();

        int[][] matrix = new int[rows][columns];

        //Elements input
        System.out.println("Enter the matrix elements: ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        int sum = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){

                sum += matrix[i][j];
            }
        }
            System.out.println("The sum is "+sum);

        sc.close();
    }
}
