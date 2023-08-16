package book.chapter15.chapter_examples.validation;

import book.chapter15.chapter_examples.validation.entities.Student;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractStudentsBuilder {
    // protected - it is often accessed from a subclass
    protected Set<Student> students;
    public AbstractStudentsBuilder() {
        students = new HashSet<Student>();
    }
    public AbstractStudentsBuilder(Set<Student> students) {
        this.students = students;
    }
    public Set<Student> getStudents() {
        return students;
    }
    public abstract void buildSetStudents(String filename);
}