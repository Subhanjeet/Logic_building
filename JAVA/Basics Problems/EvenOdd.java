import java.util.*;

class solution{

    public void EvenOdd(int num){
        if(num %2 == 0){
            System.out.println("Number"+num+" is Even");
        }else{
        System.out.println("Number "+num+" is an Odd number");
        }
    }
}

public class EvenOdd {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check Even or Odd number: ");
        int number = sc.nextInt();

        solution ans = new solution();
        ans.EvenOdd(number);
    }
}
