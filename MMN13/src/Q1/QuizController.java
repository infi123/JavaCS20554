package Q1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuizController {

    @FXML
    private Button answerButton1;
    @FXML
    private Button answerButton2;
    @FXML
    private Button answerButton3;
    @FXML
    private Button answerButton4;
    @FXML
    private Label feedbackLabel;
    @FXML
    private Label questionLabel;
    @FXML
    private Button continueButton;

    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    public void initialize() {
        setupQuestions();
        displayQuestion();
        continueButton.setVisible(false); // Initially hide the continue button
    }

    private void setupQuestions() {
        questions = Arrays.asList(
            new Question("Question 1?", "Correct Answer 1", Arrays.asList("Wrong 1", "Wrong 2", "Wrong 3")),
            new Question("Question 2?", "Correct Answer 2", Arrays.asList("Wrong 1", "Wrong 2", "Wrong 3")),
            new Question("Question 3?", "Correct Answer 3", Arrays.asList("Wrong 1", "Wrong 2", "Wrong 3"))
            // ... add more questions as needed
        );
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionLabel.setText(currentQuestion.getQuestionText());

            List<String> answers = currentQuestion.getAnswers();
            Collections.shuffle(answers);

            answerButton1.setText(answers.get(0));
            answerButton2.setText(answers.get(1));
            answerButton3.setText(answers.get(2));
            answerButton4.setText(answers.get(3));

            answerButton1.setDisable(false);
            answerButton2.setDisable(false);
            answerButton3.setDisable(false);
            answerButton4.setDisable(false);

            feedbackLabel.setText("");
            continueButton.setVisible(false); // Hide the continue button
        } else {
            displayFinalScore();
        }
    }

    private void displayFinalScore() {
        // Use the questionLabel to show the final score.
        questionLabel.setText("Final score: " + String.format("%.2f%%", ((double) score / questions.size() * 100)));
        
        // Hide all other UI components.
        feedbackLabel.setVisible(false);
        answerButton1.setVisible(false);
        answerButton2.setVisible(false);
        answerButton3.setVisible(false);
        answerButton4.setVisible(false);
        continueButton.setVisible(false);
    }

    @FXML
    void handleAnswerAction(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String selectedAnswer = clickedButton.getText();
        Question currentQuestion = questions.get(currentQuestionIndex);

        if (currentQuestion.isCorrect(selectedAnswer)) {
            score++;
            feedbackLabel.setText("Correct!");
        } else {
            feedbackLabel.setText("Incorrect! The correct answer was: " + currentQuestion.getCorrectAnswer());
        }

        // Disable the buttons after an answer has been selected
        answerButton1.setDisable(true);
        answerButton2.setDisable(true);
        answerButton3.setDisable(true);
        answerButton4.setDisable(true);

        // Show the continue button
        continueButton.setVisible(true);
    }

    @FXML
    void handleContinueAction(ActionEvent event) {
        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex++;
            displayQuestion();
        } else {
            displayFinalScore();
        }
    }
}
