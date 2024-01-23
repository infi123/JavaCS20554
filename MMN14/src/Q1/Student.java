package Q1;

import java.util.Date;

/**
 * This class represents a student with personal details.
 * It implements the Comparable interface to allow for sorting students, specifically based on their ID.
 */
class Student implements Comparable<Student> {
    private String firstName; // The student's first name
    private String lastName;  // The student's last name
    private String id;        // The student's identification number
    private Date birthDate;   // The student's date of birth

    /**
     * Constructs a new Student instance.
     *
     * @param firstName The first name of the student
     * @param lastName  The last name of the student
     * @param id        The identification number of the student
     * @param birthDate The date of birth of the student
     */
    public Student(String firstName, String lastName, String id, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.birthDate = birthDate;
    }

    /**
     * Compares this student with another student for order.
     * Returns a negative integer, zero, or a positive integer as this student's ID
     * is less than, equal to, or greater than the specified student's ID.
     *
     * @param other The other student to be compared
     * @return a negative integer, zero, or a positive integer as this student's ID
     *         is less than, equal to, or greater than the specified student's ID
     */
    @Override
    public int compareTo(Student other) {
        return this.id.compareTo(other.id);
    }

    /**
     * Returns a string representation of the student.
     *
     * @return a string representation of the student
     */
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
