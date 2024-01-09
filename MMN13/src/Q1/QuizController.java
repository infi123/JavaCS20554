package Q1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
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
    }

    private void setupQuestions() {
        questions = new ArrayList<>();
        questions.add(new Question("Question 1?", "Correct Answer 1", Arrays.asList("Wrong 1", "Wrong 2", "Wrong 3")));
        questions.add(new Question("Question 2?", "Correct Answer 2", Arrays.asList("Wrong 1", "Wrong 2", "Wrong 3")));
        questions.add(new Question("Question 3?", "Correct Answer 3", Arrays.asList("Wrong 1", "Wrong 2", "Wrong 3")));
        // Add more questions as needed
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionLabel.setText(currentQuestion.getQuestionText());

            List<String> answers = currentQuestion.getAnswers();
            Collections.shuffle(answers);

            // Assign each answer to a button
            answerButton1.setText(answers.get(0));
            answerButton2.setText(answers.get(1));
            answerButton3.setText(answers.get(2));
            answerButton4.setText(answers.get(3));

            feedbackLabel.setText(""); // Clear feedback label
            setButtonsDisabled(false); // Enable answer buttons
        } else {
            displayFinalScore();
        }
        // Hide the continue button when displaying a new question
        continueButton.setVisible(false);
    }

    @FXML
    void handleContinueAction(ActionEvent event) {
        if (currentQuestionIndex < questions.size()) {
            displayQuestion();
        } else {
            displayFinalScore();
        }
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
            feedbackLabel.setText("Incorrect! The correct answer is: " + currentQuestion.getCorrectAnswer());
        }

        setButtonsDisabled(true); // Disable answer buttons after selection

        currentQuestionIndex++; // Prepare for the next question
        if (currentQuestionIndex < questions.size()) {
            // Wait a bit before showing the next question
            new Thread(() -> {
                try {
                    Thread.sleep(2000); // wait for 2 seconds
                    javafx.application.Platform.runLater(this::displayQuestion);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        } else {
            // If there are no more questions, display the final score
            displayFinalScore();
        }
        // Show continue button after an answer is selected
        continueButton.setVisible(true);
    }

    private void setButtonsDisabled(boolean disabled) {
        answerButton1.setDisable(disabled);
        answerButton2.setDisable(disabled);
        answerButton3.setDisable(disabled);
        answerButton4.setDisable(disabled);
    }

    private void displayFinalScore() {
        double finalScore = ((double) score / questions.size()) * 100;
        feedbackLabel.setText("Final score: " + String.format("%.2f", finalScore) + "%");
        // Optionally, add logic to restart the quiz or close the application
    }

}
