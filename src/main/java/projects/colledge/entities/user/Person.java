package projects.colledge.entities.user;

import projects.colledge.entities.date.Date;

import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    @Serial
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private int age;
    private Date dateOfBirth;

    public Person() {
    }

    public Person(int id, String firstName, String lastName, int age, Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=" + id).append(", firstName='" + firstName + '\'');
        sb.append(", lastName='" + lastName + '\'');
        sb.append(", age=" + age + ", " + dateOfBirth).append('}');
        return sb.toString();
    }
}
