import java.util.Scanner;

public class FedIncomeTax
{
    public static void main(String[] args) {
        double tax=0 ,income;
        int status;

        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter 1 for single or 2 for married");
        status = scan.nextInt();
        System.out.print("Enter your income: ");
        income = scan.nextDouble();
        if (status == 1) {
            if (income >= 0 && income <= 9525) {
                tax = income * .10;
            } else if (income >= 9526 && income <= 38700) {
                tax = 953 + (income - 9525) * .12;
            } else if (income >= 38701 && income <= 82500) {
                tax = 4453 + (income - 38700) * .22;
            } else if (income >= 82501 && income <= 157500) {
                tax = 14090 + (income - 82500) * .24;
            } else if (income >= 157501 && income <= 200000) {
                tax = 32090 + (income - 157500) * .32;
            } else if (income >= 200001 && income <= 500000) {
                tax = 45690 + (income - 200000) * .35;
            } else if (income >= 500001) {
                tax = 150690 + (income - 500000) * .37;
            }
        }else if (status == 2) {
                if (income >= 0 && income <= 19050) {
                    tax = income * .10;
                } else if (income >= 19051 && income <= 77400) {
                    tax = 953 + (income - 19050) * .12;
                } else if (income >= 77401 && income <= 165000) {
                    tax = 4453 + (income - 77400) * .22;
                } else if (income >= 165001 && income <= 315000) {
                    tax = 14090 + (income - 165000) * .24;
                } else if (income >= 315001 && income <= 400000) {
                    tax = 32090 + (income - 315000) * .32;
                } else if (income >= 400001 && income <= 600000) {
                    tax = 45690 + (income - 400000) * .35;
                } else if (income >= 600001) {
                    tax = 150690 + (income - 600000) * .37;
                }
            } else {
                System.out.println("\nInvalid Entry! Try again");
                System.out.println(status);
            }
            System.out.printf("\nYour income tax is %5.2f", tax);
    }
}
