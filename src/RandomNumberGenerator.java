import java.util.Scanner;

public class RandomNumberGenerator {
    public static void main(String[] args)
    {
     Scanner input = new Scanner(System.in);

     int min = 111; // This is the minimum number possible to generate
     int max = 999; // This is tha maximum number possible to generate
     int range = max - min;
     /*
     Math.random() generates a number greater than 0.0 and less than 1.0
     We must multiply the result of Math.random() * the range to get the minimum and maximum values we
     want. After multiplying we add the minimum so that it can never be lower than it.
     Ex:
     999 - 111 = 888.   888 * 0.0 = 0.     0 + 111 = 111.
     999 - 111 = 888.   888 * 1.0 = 888.    888 + 111 = 999
     999 - 111 = 888.   888 * 0.5 = 444.    444 + 111 = 555
        etc.
      */

     int matching = 0; // This will later be used to count the matching number of digits in box bet.
     char selectedNumArray[], guessArray[]; // This is used later to store the numbers when they're broken into arrays
     char blocker = 'x'; // This is used to cover a race condition. Read below.
        /*
        If we have the number 252, and I enter the number 222 then we have a race condition
        A race condition is essentially a rare event that can cause unexpected behavior
        When we match 252 to 222 scanning number by number and we didn't use this catch... then it would say you got
        3 matches and won a box bet... but you shouldn't have.
        Since it is always checking in order from index 0 to index 2 (3 numbers, indexes start at 0), then 2 will
        always match index 0, it will never even check the 5 because 2 always matches at index 0. So what we do is
        when we match a number, we replace it with X. Something that the user is unable to enter as a guess, so that
        it cannot be matched two times.
         */

     int selectedNumber = (int)(Math.random()*range)+min; // This generates the random number that we need.
     //System.out.println(selectedNumber); //For debugging purposes, you need to know the random number in advance.
        // I've commented the above line out to prevent it from running.
     System.out.println("Welcome to the NH Lottery, what number would you like to play?");
     int guess = input.nextInt();

     System.out.println("You guessed "+guess+"... the number is: "+selectedNumber);

     selectedNumArray = Integer.toString(selectedNumber).toCharArray();
     guessArray = Integer.toString(guess).toCharArray();

     /*
     Above we are taking the two numbers (selectedNumber & guess) and turning them into arrays.
     If selectedNumber was 345 and guess was 896 then we would have arrays that look like this
     [0, 1, 2] INDEX (this is just for reference)
     [3, 4, 5]
     [8, 9, 6]

     We can now reference these above arrays by calling their index.
     Let's name them.
     A = [3, 4, 5]
     B = [8, 9, 6]

     Remember that indexes always start at 0 in Java.
     We can reference the second number in Array a by doing this: A[1] (it would now reference the number 4)
      */

     for (int i = 0; i < guessArray.length; i++)
     /*
     So here we are starting our for loop. It is a nested for loop (a for loop with a for loop inside).
     In the first one we are having it go through each of the characters in guessArray, which
     remember is guess broken into an array. If we assumed the guessed number was 345, then it would
     look like [3, 4, 5]. We will be stepping through each one individually.
      */
     {
         for (int j = 0; j < selectedNumArray.length; j++)
         {
             /*
             Just like above, we are starting another for loop. This one is for the selectedNumArray which remember
             is equal to the broken up version of selectedNumber. If selectedNumber was 896, then it would look like
             [8, 9, 6]. We will once again be stepping through each one individually.
              */
             if (guessArray[i] == selectedNumArray[j])
             {
                 /*
                 Here we are checking to see if the current number guessArray is the same as the current number in
                 selectedNumArray. The process that this will go through is:
                 Does guessArray[0] == selectedNumArray[0]?
                 Does guessArray[0] == selectedNumArray[1]?
                 Does guessArray[0] == selectedNumArray[2]?
                 Does guessArray[1] == selectedNumArray[0]?
                 Does guessArray[1] == selectedNumArray[1]?
                 and so on.
                  */
                 matching++; //If we find a match, add it to the matching count. We use this later to determine victory.
                 selectedNumArray[j] = blocker; //If it matches, replace the number with an X
                 break; //Stop. Don't keep looking through the remaining selectedNumbers. Once we match one, we move on.
             }
         }
     }
     if (guess == selectedNumber) //Straight bet. Does the number match exactly?
     {
            System.out.println("You win a straight bet!");
     }
     if (matching == selectedNumArray.length) //Boxed bet. Does the matching number equal the total number of digits?
     {
         System.out.println("You win a boxed bet!");
     }
     if (guess != selectedNumber && matching != selectedNumArray.length) //Does it match neither?
     {
         System.out.println("You did not win.");
         if (matching == 1) //This is just for correct grammar. 1 number, not 1 numbers. 
         {
             System.out.println("You matched 1 number on a straight bet");
         }else if(matching == 0 || matching >=2)
         {
             System.out.println("You matched " + matching + " numbers on a straight bet");
         }
     }
    }
}
