package Q1;

import java.util.Date;

// Student class
class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private String id;
    private Date birthDate;

    public Student(String firstName, String lastName, String id, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public int compareTo(Student other) {
        return this.id.compareTo(other.id);
    }

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

