package Q1;

import java.util.Iterator;
import java.util.Date;


// Main class for testing
public class Main {
    public static void main(String[] args) {
        AssociationTable<Student, Integer> table = new AssociationTable<>();

        // Existing student creation
        Student student1 = new Student("John", "Doe", "123", new Date());
        Student student2 = new Student("Jane", "Doe", "456", new Date());
        Student student3 = new Student("Jim", "Beam", "789", new Date());

        // Add existing students to the table
        table.add(student1, 85);
        table.add(student2, 90);
        table.add(student3, 75);

        // Update a student's grade
        table.add(student2, 95);

        // Create and add a new student
        Student student4 = new Student("Alice", "Smith", "101", new Date());
        table.add(student4, 88);
        
        // Remove a student
        table.remove(student3);

        // Print the table
        Iterator<Student> it = table.keyIterator();
        while (it.hasNext()) {
            Student student = it.next();
            System.out.println(student + " - Average Grade: " + table.get(student));
        }

    }
}
