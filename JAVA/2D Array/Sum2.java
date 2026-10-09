// Calculate the sum of each row separately.

import java.util.*;
public class Sum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //rows and columns no.
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();

        //2D array
        int[][] matrix = new int[rows][columns];

        //Element of matrix
        System.out.println("Enter the elements: ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        //sum of each row
        for(int i = 0; i < rows; i++){
            int sum = 0;
            for(int j = 0; j < columns; j++){
                sum += matrix[i][j];
            }

            System.out.println("Row " + (i+1) + " sum = " + sum);
        }

        sc.close();
    }
}
