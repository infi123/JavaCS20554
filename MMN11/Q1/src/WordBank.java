import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * The WordBank class represents a collection of words for a guessing game.
 */
public class WordBank {
    // List of words
    private List<String> words = Arrays.asList("apple", "banana", "cherry");

    /**
     * This method returns a random word from the word bank.
     * @return A random word.
     */
    public String getRandomWord() {
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }
}