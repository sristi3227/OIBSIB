

package Projects;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        int totalScore = 0;
        int totalRounds = 0;
        
        System.out.println("Instructions:~");
        System.out.println("1. Guess a number between 1 to 100 ");
        System.out.println("2. You have 8 attempts to guess the correct answer ");
        System.out.println("3. Play and enjoy");
        

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Round " + (totalRounds + 1));
            while (!guessedCorrectly && attempts < 8) { 
                System.out.print("Enter your guess (between 1 and 100): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalScore += (100-attempts);
                } else if (userGuess < randomNumber) {
                    System.out.println("The number is lower than the correct number. Try again.");
                } else {
                    System.out.println("The number is higher than the correct number. Try again.");
                }
                 System.out.println("no of attempts left="+(8-attempts));
            }
           

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've exceeded the maximum number of attempts.");
                System.out.println("The correct number was: " + randomNumber);
            }

            totalRounds++;
            System.out.println("Your current total score is: " + totalScore);
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next();
            playAgain = playChoice.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}

    

