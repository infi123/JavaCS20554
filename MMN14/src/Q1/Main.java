package Q1;

import java.util.Iterator;
import java.util.Date;

/**
 * Main class for testing the AssociationTable.
 * Demonstrates the functionality of adding, updating, and removing entries,
 * as well as iterating over the table.
 */
public class Main {
    public static void main(String[] args) {
        // Create an instance of AssociationTable to store Student and their grades
        AssociationTable<Student, Integer> table = new AssociationTable<>();

        // Create student instances
        Student student1 = new Student("John", "Doe", "123", new Date());
        Student student2 = new Student("Jane", "Doe", "456", new Date());
        Student student3 = new Student("Jim", "Beam", "789", new Date());

        // Add students to the table with their grades
        table.add(student1, 85);
        table.add(student2, 90);
        table.add(student3, 75);

        // Update the grade of a student
        table.add(student2, 95);

        // Create and add a new student
        Student student4 = new Student("Alice", "Smith", "101", new Date());
        table.add(student4, 88);
        
        // Remove a student from the table
        table.remove(student3);

        // Iterate over and print the contents of the table
        Iterator<Student> it = table.keyIterator();
        while (it.hasNext()) {
            Student student = it.next();
            System.out.println(student + " - Average Grade: " + table.get(student));
        }
    }
}
