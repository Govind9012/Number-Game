import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minNum = 1;
        int maxNum = 100;
        int secretNumber = random.nextInt(maxNum - minNum + 1) + minNum;

        int maxAttempts = 10;
        int roundsPlayed = 0;
        int totalAttempts = 0;
        int roundsWon = 0;

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Welcome to Guess the Number!");
            System.out.println("Try to guess the number between " + minNum + " and " + maxNum);

            int attempts = 0;
            boolean correctGuess = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                totalAttempts++;
                attempts++;

                if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number: " + secretNumber);
                    correctGuess = true;
                    roundsWon++;
                    break;
                }
            }

            if (!correctGuess) {
                System.out.println("You've run out of attempts. The correct number was: " + secretNumber);
            }

            roundsPlayed++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.nextLine().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }

            // Generate a new secret number for the next round
            secretNumber = random.nextInt(maxNum - minNum + 1) + minNum;
        }

        System.out.println("Game Over!");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Total Attempts: " + totalAttempts);

        scanner.close();
    }
}
