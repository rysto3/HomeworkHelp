import java.util.Scanner;

public class university {
    public static void main(String[] args)
    {
        //Initialize variables
        String sport;
        double gpa;
        double sat;

        //Initialize scanner
        Scanner scan = new Scanner(System.in);

        //Request input from user on GPA, SAT Score, and Sports Participation
        System.out.println("Enter your GPA please:");
        gpa = scan.nextDouble();

        System.out.println("Enter your SAT score:");
        sat = scan.nextDouble();

        System.out.println("Were you involved in athletics? (y/n)");
        sport = scan.nextLine();
        sport = scan.nextLine();

        //Find what universities this person would be admitted to

        //Yarvard University requires you have a GPA of at least 3.5 AND an SAT Score of at least 1250 AND involvement in sports
        //Qualifying for Yarvard automatically qualifies you for all other universities
        if ((gpa>=3.5 && sat>=1250 && sport.equalsIgnoreCase("y")))
        {
            System.out.println("Congratulations! You are admitted to Slimy Pebble University");
            System.out.println("Congratulations! You are admitted to Whattsamatta University");
            System.out.println("Congratulations! You are admitted to Pittsburgh University");
            System.out.println("Congratulations! You are admitted to Yarvard University");
        }
        //Pittsburgh University requires a GPA of at least 3.0 OR an SAT score of at least 1050 AND involvement in sports
        //Qualifying for Pittsburgh automatically qualifies you for Whattsamatta and Slimy Pebble
        else if ((gpa>=3.0 || sat>=1050) && sport.equalsIgnoreCase("y"))
        {
            System.out.println("Congratulations! You are admitted to Slimy Pebble University");
            System.out.println("Congratulations! You are admitted to Whattsamatta University");
            System.out.println("Congratulations! You are admitted to Pittsburgh University");
        }
        //Whattsamatta University requires a GPA of at least 2.5 AND an SAT score of at least 1050 OR involvement in sports
        //Qualifying for Whattsamatta automatically qualifies you for Slimy Pebble University
        else if (gpa>=2.5 && (sat>=1050 || sport.equalsIgnoreCase("y")))
        {
            System.out.println("Congratulations! You are admitted to Slimy Pebble University");
            System.out.println("Congratulations! You are admitted to Whattsamatta University");
        }
        //Slimy Pebble requires GPA 2.0 or higher OR SAT of 900 or higher. Sports is not considered.
        else if ((gpa>=2.0 || sat>=900) && sport.equalsIgnoreCase("y") || sport.equalsIgnoreCase("n"))
        {
            System.out.println("Congratulations! You are admitted to Slimy Pebble University");
        }
    }
}
