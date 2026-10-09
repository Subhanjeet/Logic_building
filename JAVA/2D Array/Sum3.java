// Calculate the sum of each column separately.

import java.util.*;
public class Sum3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //print rows and  columns
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();

        int[][] matrix = new int[rows][columns];

        //input matrix element
        System.out.println("Enter the elements of the matrix: ");
        for(int i=0; i<rows;i++){
            for(int j=0;j<columns;j++){
                matrix[i][j] = sc.nextInt();    
            }
        }

        // sum of each column
        for(int j=0;j<columns;j++){
            int sum = 0;
            for(int i=0;i<rows;i++){
                sum += matrix[i][j];
            }
            System.out.println("The sum of column "+(j+1)+" is: "+sum);
        }
        sc.close();
    }
}
