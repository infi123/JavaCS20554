import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordBank {
    private List<String> words = Arrays.asList("apple", "banana", "cherry");

    public String getRandomWord() {
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }
}