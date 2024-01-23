package Q2;

import java.util.TreeMap;

/**
 * The PhoneBook class represents a phone book with operations to manage contacts.
 * It uses a TreeMap to store contact names and their associated phone numbers.
 */
public class PhoneBook {
    private TreeMap<String, String> contacts; // TreeMap to store contacts. Key: Name, Value: Phone Number

    /**
     * Constructor for PhoneBook class.
     * Initializes a new TreeMap to hold contacts.
     */
    public PhoneBook() {
        contacts = new TreeMap<>();
    }

    /**
     * Adds or updates a contact in the phone book.
     * If the contact already exists, its phone number is updated.
     * 
     * @param name The name of the contact to add or update.
     * @param phoneNumber The phone number associated with the contact.
     */
    public void addContact(String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
    }

    /**
     * Deletes a contact from the phone book.
     * 
     * @param name The name of the contact to delete.
     * @return true if the contact was successfully deleted, false if it was not found.
     */
    public boolean deleteContact(String name) {
        return contacts.remove(name) != null;
    }

    /**
     * Updates the phone number of an existing contact.
     * 
     * @param name The name of the contact whose phone number is to be updated.
     * @param newPhoneNumber The new phone number of the contact.
     */
    public void updateContact(String name, String newPhoneNumber) {
        contacts.put(name, newPhoneNumber);
    }

    /**
     * Retrieves the phone number associated with a given contact name.
     * 
     * @param name The name of the contact.
     * @return The phone number of the contact, or null if the contact does not exist.
     */
    public String getPhoneNumber(String name) {
        return contacts.get(name);
    }

    /**
     * Returns all contacts in the phone book.
     * 
     * @return A TreeMap of all contacts (names and phone numbers).
     */
    public TreeMap<String, String> getAllContacts() {
        return contacts;
    }
}
