import java.util.HashSet;
import java.util.Set;

public class ChosenWord {
    private String word;
    private Set<Character> guessedLetters = new HashSet<>();

    public ChosenWord(String word) {
        this.word = word;
    }

    public boolean guessLetter(char letter) {
        if (word.indexOf(letter) >= 0) {
            guessedLetters.add(letter);
            return true;
        }
        return false;
    }

    public boolean isFullyGuessed() {
        for (char letter : word.toCharArray()) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }

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