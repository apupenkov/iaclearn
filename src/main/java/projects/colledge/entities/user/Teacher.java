package projects.colledge.entities.user;

import projects.colledge.entities.date.Date;

import java.io.Serial;
import java.io.Serializable;

public class Teacher extends Person implements Serializable {
    private String post;
    @Serial
    private static final long serialVersionUID = 1L;

    public Teacher(int id, String firstName, String lastName, int age, Date dateOfBirth) {
        super(id, firstName, lastName, age, dateOfBirth);
    }
}
