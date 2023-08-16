package projects.colledge.entities.user;

import projects.colledge.entities.date.Date;

import java.io.Serializable;

public class Student extends Person implements Serializable {


    public Student(int id, String firstName, String lastName, int age, Date dateOfBirth) {
        super(id, firstName, lastName, age, dateOfBirth);
    }
}
