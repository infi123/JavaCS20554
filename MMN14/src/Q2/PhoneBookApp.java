package Q2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.stream.Collectors;

/**
 * The PhoneBookApp class extends the Application class from JavaFX.
 * This class represents the main user interface for the phone book application.
 */
public class PhoneBookApp extends Application {

    private PhoneBook phoneBook = new PhoneBook(); // Instance of the PhoneBook class to manage contacts.
    private ListView<String> listView = new ListView<>(); // ListView to display the list of contacts.

    /**
     * The start method sets up the user interface and event handling.
     * @param primaryStage The primary stage for this application, onto which the application scene can be set.
     */
    @Override
    public void start(Stage primaryStage) {
        // UI components
        TextField nameField = new TextField(); // TextField for entering names.
        nameField.setPromptText("Name");
        TextField phoneField = new TextField(); // TextField for entering phone numbers.
        phoneField.setPromptText("Phone Number");
        Button addButton = new Button("Add Contact"); // Button to add new contacts.
        Button deleteButton = new Button("Delete Contact"); // Button to delete existing contacts.
        Button updateButton = new Button("Update Contact"); // Button to update existing contacts.

        // Event Handlers
        addButton.setOnAction(e -> {
            phoneBook.addContact(nameField.getText(), phoneField.getText()); // Add contact on button click.
            updateListView(); // Update the ListView to reflect the change.
        });
        deleteButton.setOnAction(e -> {
            phoneBook.deleteContact(nameField.getText()); // Delete contact on button click.
            updateListView(); // Update the ListView to reflect the change.
        });
        updateButton.setOnAction(e -> {
            phoneBook.updateContact(nameField.getText(), phoneField.getText()); // Update contact on button click.
            updateListView(); // Update the ListView to reflect the change.
        });

        // Layout setup
        VBox layout = new VBox(10, nameField, phoneField, addButton, deleteButton, updateButton, listView);
        Scene scene = new Scene(layout, 300, 250); // Scene containing all UI elements.

        // Stage setup
        primaryStage.setTitle("Phone Book Application"); // Set the title of the window.
        primaryStage.setScene(scene); // Place the scene in the stage.
        primaryStage.show(); // Display the stage.
    }

    /**
     * Updates the ListView to display the current list of contacts in the phone book.
     */
    private void updateListView() {
        listView.getItems().clear(); // Clear the current items in the ListView.
        listView.getItems().addAll(phoneBook.getAllContacts().entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue()) // Map each entry to a string.
                .collect(Collectors.toList())); // Collect the stream into a list and add to ListView.
    }

    /**
     * The main method to launch the application.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application.
    }
}
