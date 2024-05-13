import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int randomNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        int attempts = 0;
        final int MAX_ATTEMPTS = 5;

        System.out.println("\nWelcome to the Guess the Number Game!");
        System.out.println("----------------------------------------\n");
        System.out.println("I have selected a number between 1 and 100. Can you guess it?");
        System.out.println("You only have 5 attempts !\n");
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly in "
                        + attempts + " attempts.");
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low. Try again.");
                System.out.println("Attempts left : " + (MAX_ATTEMPTS - attempts));
                System.out.println("-------------------------------------");
            } else {
                System.out.println("Your guess is too high. Try again.");
                System.out.println("Attempts left : " + (MAX_ATTEMPTS - attempts));
                System.out.println("-------------------------------------");
            }
        }

        if (attempts == MAX_ATTEMPTS) {
            System.out
                    .println("Sorry, you have reached the maximum number of attempts. The number was: " + randomNumber);
        }

        scanner.close();
    }
}
