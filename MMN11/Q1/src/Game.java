import java.util.Scanner;

public class Game {
    private WordBank wordBank = new WordBank();
    private ChosenWord chosenWord;
    private int guesses = 0;

    public void startGame() {
        chosenWord = new ChosenWord(wordBank.getRandomWord());
        try (Scanner scanner = new Scanner(System.in)) {
            while (!chosenWord.isFullyGuessed()) {
                System.out.println("Current word: " + chosenWord.getDisplayWord());
                System.out.print("Guess a letter: ");
                char guess = scanner.nextLine().charAt(0);

                if (chosenWord.guessLetter(guess)) {
                    System.out.println("Correct guess!");
                } else {
                    System.out.println("Incorrect guess.");
                }

                guesses++;
            }
        }

        System.out.println("Congratulations! You've guessed the word: " + chosenWord.getDisplayWord());
        System.out.println("It took you " + guesses + " guesses.");
    }
}