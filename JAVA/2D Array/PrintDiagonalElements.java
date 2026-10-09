// Write A Program To Print Diagonal Elements

import java.util.*;

public class PrintDiagonalElements {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter columns: ");
        int columns = sc.nextInt();

        int[][] matrix = new int[rows][columns];

        System.out.println("Enter elements:");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Diagonal: ");
        for(int i = 0; i < rows && i < columns; i++){
            System.out.print(matrix[i][i] + " ");
        }
        sc.close();
    }
}