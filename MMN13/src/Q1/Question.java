package Q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private String questionText;
    private String correctAnswer;
    private List<String> answers;

    public Question(String questionText, String correctAnswer, List<String> wrongAnswers) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.answers = new ArrayList<>(wrongAnswers);
        this.answers.add(correctAnswer);
        Collections.shuffle(this.answers); // Randomize the order of answers
    }

    public String getQuestionText() {
        return questionText;
    }

    public boolean isCorrect(String answer) {
        return answer.equals(correctAnswer);
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
    
    public List<String> getAnswers() {
        return answers;
    }
}
