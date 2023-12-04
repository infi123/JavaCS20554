import java.util.HashSet;
import java.util.Set;

/**
 * The ChosenWord class represents a word chosen for a guessing game.
 */
public class ChosenWord {
    // The word to be guessed
    private String word;
    // Set of letters that have been correctly guessed
    private Set<Character> guessedLetters = new HashSet<>();

    /**
     * Constructor for the ChosenWord class.
     * @param word The word to be guessed.
     */
    public ChosenWord(String word) {
        this.word = word;
    }

    /**
     * This method checks if a guessed letter is in the word.
     * @param letter The guessed letter.
     * @return true if the letter is in the word, false otherwise.
     */
    public boolean guessLetter(char letter) {
        if (word.indexOf(letter) >= 0) {
            guessedLetters.add(letter);
            return true;
        }
        return false;
    }

    /**
     * This method checks if the word has been fully guessed.
     * @return true if all letters of the word have been guessed, false otherwise.
     */
    public boolean isFullyGuessed() {
        for (char letter : word.toCharArray()) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method returns the current state of the guessed word.
     * @return A string representing the guessed word with unguessed letters replaced by '_'.
     */
    public String getDisplayWord() {
        StringBuilder displayWord = new StringBuilder();
        for (char letter : word.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                displayWord.append(letter);
            } else {
                displayWord.append('_');
            }
        }
        return displayWord.toString();
    }
}