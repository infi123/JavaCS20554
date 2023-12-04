import java.util.Scanner;

/**
 * The Game class represents a word guessing game.
 */
public class Game {
    // WordBank object to store and manage the list of words
    private WordBank wordBank = new WordBank();
    // ChosenWord object to represent the word chosen for the current game
    private ChosenWord chosenWord;
    // Counter for the number of guesses made by the player
    private int guesses = 0;

    /**
     * This method starts the game.
     */
    public void startGame() {
        // Select a random word from the word bank
        chosenWord = new ChosenWord(wordBank.getRandomWord());
        Scanner scanner = new Scanner(System.in);
        // Continue the game until the word is fully guessed
        while (!chosenWord.isFullyGuessed()) {
            System.out.println("Current word: " + chosenWord.getDisplayWord());
            System.out.print("Guess a letter: ");
            char guess = scanner.nextLine().charAt(0);

            // Check if the guessed letter is in the word
            if (chosenWord.guessLetter(guess)) {
                System.out.println("Correct guess!");
            } else {
                System.out.println("Incorrect guess.");
            }

            // Increment the guess counter
            guesses++;
        }

        // Display the success message and the number of guesses made
        System.out.println("Congratulations! You've guessed the word: " + chosenWord.getDisplayWord());
        System.out.println("It took you " + guesses + " guesses.");
        scanner.close();
    }
}