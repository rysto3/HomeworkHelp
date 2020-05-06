import java.util.Scanner;

public class HailstoneNumbers {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        String response;
        do {
            System.out.println("Enter the first term of the sequence: ");
            number = input.nextInt();
            int steps = 0;
            do {
                steps++;
                System.out.print(number + ", ");
                if (number % 2 == 0) {
                    //The number is even
                    number = number / 2;
                } else {
                    //The number is odd
                    number = (number * 3) + 1;
                }
            } while (number > 1);
            System.out.print("1");
            System.out.println("\nIt took " + steps + " terms to reach the number 1");
            System.out.println("Would you like to try again (y/n)?: ");
            response = input.next();
        }while(response.matches("y"));
    }
}
