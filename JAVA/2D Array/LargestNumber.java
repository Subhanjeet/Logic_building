//Find the maximum number in the entire matrix

import java.util.*;
public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();

        int[][] matrix = new int[rows][columns];

        System.out.println("Enter the matrix elements: ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        int largestNumber = Integer.MIN_VALUE;

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(matrix[i][j]>largestNumber){
                    largestNumber=matrix[i][j];
                }
            }
        }
                System.out.println("largest number: "+largestNumber);
                sc.close();
    }
}
