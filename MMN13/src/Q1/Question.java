package Q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a single multiple-choice question.
 * It includes the question text, a list of possible answers, and the correct answer.
 */
public class Question {
    private String questionText; // The text of the question
    private String correctAnswer; // The correct answer to the question
    private List<String> answers; // A list of all possible answers including the correct one

    /**
     * Constructs a Question object.
     * 
     * @param questionText The text of the question.
     * @param correctAnswer The correct answer to the question.
     * @param wrongAnswers A list of wrong answers for the question.
     */
    public Question(String questionText, String correctAnswer, List<String> wrongAnswers) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        // Initialize answers list with wrong answers and then add the correct one
        this.answers = new ArrayList<>(wrongAnswers);
        this.answers.add(correctAnswer);
        // Shuffle the answers to ensure they are presented in random order
        Collections.shuffle(this.answers);
    }

    /**
     * Gets the text of the question.
     * 
     * @return The text of the question.
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Checks if the provided answer is correct.
     * 
     * @param answer The answer to be checked.
     * @return true if the provided answer is correct, false otherwise.
     */
    public boolean isCorrect(String answer) {
        return answer.equals(correctAnswer);
    }

    /**
     * Gets the correct answer to the question.
     * 
     * @return The correct answer.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Gets a list of all possible answers.
     * 
     * @return A shuffled list of all answers, including the correct one.
     */
    public List<String> getAnswers() {
        return answers;
    }
}
