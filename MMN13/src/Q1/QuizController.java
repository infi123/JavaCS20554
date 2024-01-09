package Q1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Controller class for the Quiz application.
 * This class is responsible for handling user interactions and updating the UI accordingly.
 */
public class QuizController {

    // FXML annotations to bind to the UI components from layout.fxml
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
    private Button continueButton; // Will also be used as the restart button

    // List to hold the questions for the quiz
    private List<Question> questions;
    // Index to keep track of the current question being displayed
    private int currentQuestionIndex = 0;
    // Variable to keep track of the user's score
    private int score = 0;

    /**
     * Initializes the quiz controller.
     * This method is called automatically after the FXML fields have been injected.
     */
    public void initialize() {
        setupQuestions(); // Initialize and shuffle the questions
        displayQuestion(); // Display the first question
        continueButton.setVisible(false); // Hide the continue button initially
    }

    /**
     * Sets up the list of questions for the quiz.
     * This method initializes and shuffles the questions.
     */
    private void setupQuestions() {
        questions = new ArrayList<>(Arrays.asList(
            // Initializing questions with a question text, correct answer, and wrong answers
            new Question("Question 1?", "Correct Answer 1", Arrays.asList("Wrong 1", "Wrong 2", "Wrong 3")),
            new Question("Question 2?", "Correct Answer 2", Arrays.asList("Wrong 1", "Wrong 2", "Wrong 3")),
            new Question("Question 3?", "Correct Answer 3", Arrays.asList("Wrong 1", "Wrong 2", "Wrong 3"))
        ));
        Collections.shuffle(questions); // Shuffle the questions for random order
    }

    /**
     * Displays the current question and its possible answers.
     * Updates the UI with the current question and answer choices.
     */
    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionLabel.setText(currentQuestion.getQuestionText());

            // Shuffle and display the answers
            List<String> answers = currentQuestion.getAnswers();
            Collections.shuffle(answers);
            answerButton1.setText(answers.get(0));
            answerButton2.setText(answers.get(1));
            answerButton3.setText(answers.get(2));
            answerButton4.setText(answers.get(3));

            // Prepare the UI for the question
            setAnswerButtonsDisabled(false);
            setAnswerButtonsVisible(true);
            feedbackLabel.setText("");
            continueButton.setVisible(false);
        } else {
            displayFinalScore(); // Display the final score if no more questions are left
        }
    }

    /**
     * Displays the final score at the end of the quiz.
     * Changes the UI to show the user's score and repurpose the continue button for restarting.
     */
    private void displayFinalScore() {
        questionLabel.setText("Final score: " + String.format("%.2f%%", ((double) score / questions.size() * 100)));

        // Hide the answer buttons and feedback label
        setAnswerButtonsVisible(false);
        feedbackLabel.setVisible(false);

        // Repurpose the continue button as a "Restart" button
        continueButton.setText("Restart");
        continueButton.setVisible(true);
        continueButton.setOnAction(this::handleRestartAction);
    }

        /**
     * Handles the user's answer selection.
     * This method is called when any of the answer buttons are clicked.
     * @param event The event that triggered this action.
     */
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

        setAnswerButtonsDisabled(true); // Disable answer buttons

        if (currentQuestionIndex < questions.size() - 1) {
            continueButton.setText("Next");
            continueButton.setVisible(true);
            continueButton.setOnAction(this::handleContinueAction);
        } else {
            // Delay display of the final score to allow user to see feedback for the last question
            continueButton.setText("See Final Score");
            continueButton.setVisible(true);
            continueButton.setOnAction(event1 -> displayFinalScore());
        }
    }

    /**
     * Continues to the next question or ends the quiz.
     * This method is called when the continue button is clicked.
     * @param event The event that triggered this action.
     */
    @FXML
    void handleContinueAction(ActionEvent event) {
        currentQuestionIndex++; // Increment the question index to move to the next question
        displayQuestion(); // Display the next question
    }

    /**
     * Restarts the quiz.
     * This method resets the quiz to its initial state and starts over.
     * It is called when the restart button (previously the continue button) is clicked.
     * @param event The event that triggered this action.
     */
    private void handleRestartAction(ActionEvent event) {
        score = 0;
        currentQuestionIndex = 0;
        setupQuestions();
        displayQuestion();
        feedbackLabel.setVisible(true); // Ensure feedback label is visible again
    }

    /**
     * Helper method to set the disabled state of all answer buttons.
     * @param disabled The disabled state to set.
     */
    private void setAnswerButtonsDisabled(boolean disabled) {
        answerButton1.setDisable(disabled);
        answerButton2.setDisable(disabled);
        answerButton3.setDisable(disabled);
        answerButton4.setDisable(disabled);
    }

    /**
     * Helper method to set the visibility of all answer buttons.
     * @param visible The visibility state to set.
     */
    private void setAnswerButtonsVisible(boolean visible) {
        answerButton1.setVisible(visible);
        answerButton2.setVisible(visible);
        answerButton3.setVisible(visible);
        answerButton4.setVisible(visible);
    }
}