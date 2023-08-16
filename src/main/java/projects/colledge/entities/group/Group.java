package projects.colledge.entities.group;

import projects.colledge.entities.user.Student;
import projects.colledge.entities.user.Teacher;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Group implements Serializable {
    private int id;
    private String title;
    private Teacher curator;
    private Student headman;
    private List<Student> students;

    @Serial
    private static final long serialVersionUID = 1L;

    public Group() {
    }

    public Group(int id, String title, Teacher curator, Student headman, List<Student> students) {
        this.id = id;
        this.title = title;
        this.curator = curator;
        this.headman = headman;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
    }

    public Student getHeadman() {
        return headman;
    }

    public void setHeadman(Student headman) {
        this.headman = headman;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
