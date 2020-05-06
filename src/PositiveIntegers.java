import java.util.ArrayList;
import java.util.Scanner;

public class PositiveIntegers {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList factors = new ArrayList();

        int step = 0;

        System.out.println("Enter a positive integer: ");
        int enteredNumber = input.nextInt();

        while (step < enteredNumber){
            step++;
            if (enteredNumber % step == 0){
                factors.add(step);
            }
        }

        if (factors.size() <= 2) {
            System.out.println(enteredNumber + " is a prime number");
        }else{
            for (int i = 0; i < factors.size(); i++) {
                System.out.print(factors.get(i).toString());
                if (i < factors.size() - 1){
                    System.out.print(", ");
                }
            }
            System.out.println();
            System.out.println("There are "+factors.size()+" factors of "+enteredNumber);
            System.out.println(enteredNumber + " is not a prime number");
        }
    }
}
