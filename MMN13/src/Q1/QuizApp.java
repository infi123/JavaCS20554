package Q1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;

public class QuizApp extends Application {
    private int currentQuestionIndex = 0;
    private int score = 0;
    private List<Question> questions = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        setupQuestions();
        VBox root = new VBox(10);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Multiple Choice Test");
        primaryStage.setScene(scene);
        primaryStage.show();

        displayQuestion(root);
    }

    private void setupQuestions() {
        questions.add(new Question("Question 1?", "Correct Answer 1", Arrays.asList("Wrong 1", "Wrong 2", "Wrong 3")));
        questions.add(new Question("Question 2?", "Correct Answer 2", Arrays.asList("Wrong 1", "Wrong 2", "Wrong 3")));
        questions.add(new Question("Question 3?", "Correct Answer 3", Arrays.asList("Wrong 1", "Wrong 2", "Wrong 3")));
    }

    private void displayQuestion(VBox root) {
        root.getChildren().clear();
    
        Label feedbackLabel = new Label(); // Label for feedback
        feedbackLabel.setVisible(false); // Initially not visible
    
        if (currentQuestionIndex < questions.size()) {
            Question question = questions.get(currentQuestionIndex);
    
            Label questionLabel = new Label(question.getQuestionText());
            root.getChildren().addAll(questionLabel, feedbackLabel); // Add feedback label to the root
    
            List<String> answers = question.getAnswers();
            Collections.shuffle(answers);
    
            for (String answer : answers) {
                Button answerButton = new Button(answer);
                answerButton.setOnAction(event -> {
                    feedbackLabel.setVisible(true); // Make the feedback label visible
                    if (question.isCorrect(answer)) {
                        score++;
                        feedbackLabel.setText("Correct!"); // Set text to correct
                    } else {
                        feedbackLabel.setText("Incorrect!"); // Set text to incorrect
                    }
    
                    // Disable all answer buttons after a choice is made
                    root.getChildren().stream()
                        .filter(node -> node instanceof Button)
                        .forEach(node -> node.setDisable(true));
    
                    // Add a continue button to proceed to the next question
                    Button continueButton = new Button("Continue");
                    continueButton.setOnAction(e -> {
                        currentQuestionIndex++;
                        displayQuestion(root); // Show the next question
                    });
                    root.getChildren().add(continueButton);
                });
                root.getChildren().add(answerButton);
            }
        } else {
            // Calculate and display the final score
            double finalScore = (double) score / questions.size() * 100;
            feedbackLabel.setText("Final score: " + finalScore + "%");
            feedbackLabel.setVisible(true);
    
            // Add a restart button to reset the quiz
            Button restartButton = new Button("Restart");
            restartButton.setOnAction(event -> {
                currentQuestionIndex = 0;
                score = 0;
                displayQuestion(root);
            });
            root.getChildren().addAll(feedbackLabel, restartButton);
        }
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}

