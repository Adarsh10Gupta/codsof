import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        String playAgain;
        System.out.println("Welcome to the Number Guessing Game!");
        
        do {
            int targetNumber = random.nextInt(100) + 1; // Generates a number between 1 and 100
            int maxAttempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nI've picked a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts. Good luck!");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    guessedCorrectly = true;
                    score += (maxAttempts - attempt + 1); // Higher score for fewer attempts
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The correct number was: " + targetNumber);
            }

            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));
        System.out.println("\nThank you for playing! Your final score is: " + score);
        sc.close();
    }
}
