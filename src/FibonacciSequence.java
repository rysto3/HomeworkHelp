import java.util.Scanner;

public class FibonacciSequence {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        long number, num1 = 0, num2 = 1, nthTermTemp, nthTerm;
        double gm = (1 + Math.sqrt(5))/2;
        String response;
        do
        {
            System.out.println("Enter the desired number from the Fibonacci Sequence: ");
            number = input.nextInt();
            if(number <= 40) {
                for (int i = 2; i <= number; i++) {
                    nthTermTemp = num1 + num2;
                    num1 = num2;
                    num2 = nthTermTemp;
                }
                System.out.println("The Golden Mean estimate of " + number + " is " + Math.round(num1 * gm));
                //Now we check to see if it matches Binet's Formula
                nthTerm = (int) (((Math.pow(gm, number)) - (Math.pow(-gm, -number))) / Math.sqrt(5));
                System.out.println("The "+number+"th term of the Fibonacci Sequence is: "+num2);
                System.out.println("For Loop method matches Binet's Formula: " + (nthTerm == num2));
            }else{
                System.out.println("Numbers larger than 40 are not accepted");
            }
            System.out.println("\nWould you like to go again? (y/n): ");
            response = input.next();
        }while(response.matches("y"));
    }
}
