import java.util.Scanner;
import java.util.Random;

public class HangManGame {
    private static final String[] WORDS = { "java", "programming", "computer", "algorithm", "developer", "coding" };
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String word = WORDS[random.nextInt(WORDS.length)];
        char[] guessedWord = new char[word.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        int tries = 0;
        boolean wordGuessed = false;
        while (tries < MAX_TRIES && !wordGuessed) {
            System.out.println("Word: " + String.valueOf(guessedWord));
            System.out.println("----------------------");
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);

            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    found = true;
                }
            }

            if (!found) {
                tries++;
                System.out.println("Incorrect guess! You have " + (MAX_TRIES - tries) + " tries left.");
                printHangman(tries);
            }

            if (String.valueOf(guessedWord).equals(word)) {
                wordGuessed = true;
            }
        }

        if (wordGuessed) {
            System.out.println("\nCongratulations! You guessed the word: " + word);
        } else {
            System.out.println("\nSorry, you ran out of tries. The word was: " + word);
        }

        scanner.close();
    }

    private static void printHangman(int tries) {
        String[] hangman = {
                "  _______",
                "  |     |",
                "  |     O",
                "  |    /|\\",
                "  |    / \\",
                "__|__"
        };

        for (int i = 0; i < tries; i++) {
            System.out.println(hangman[i]);
        }
    }
}
