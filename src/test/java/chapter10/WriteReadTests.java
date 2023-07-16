package chapter10;

import book.chapter10.StreamInputOutputUtil;
import book.chapter10.model.Student;
import chapter10.ArgumentsProviders.StudentsByGradeArgumentsProvider;
import chapter10.ArgumentsProviders.WriteRandomNumberArgumentsProvider;
import chapter10.ArgumentsProviders.WriteSerializedStudentsArgumentsProvider;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WriteReadTests {
    @Nested
    class WriteReadRandomNumber {
        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @ArgumentsSource(WriteRandomNumberArgumentsProvider.class)
        public void writeRandomNumberTest(String path, String file, int count) {
            try {
                StreamInputOutputUtil.writeRandomNumberInFile(path, file, count);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                fail("The test failed.");
            }
        }

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @ArgumentsSource(WriteRandomNumberArgumentsProvider.class)
        public void readRandomNumberTest(String path, String file, int count) {
            try {
                assertEquals(StreamInputOutputUtil.readRandomNumbersFromFile(path, file).size(), count);
            } catch (IOException e) {
                e.printStackTrace();
                fail("The test failed.");
            }
        }

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @CsvSource(
                value = {
                        "asdfasdf,temp1.txt,5",
                        "/c/asdf/asdf/asdf,temp2.txt,10",
                        "src/main/java/blablabla,temp3.txt,300"
                }
        )
        public void writeRandomNumberFileNotFoundExceptionTest(String path, String file, int count) {
            assertThrows(FileNotFoundException.class, () -> StreamInputOutputUtil.writeRandomNumberInFile(path, file, count));
        }

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @CsvSource(
                value = {
                        "data,temp1.txt,0",
                        "data,temp2.txt,-5",
                        "data,temp3.txt,-300"
                }
        )
        public void writeRandomNumberIllegalArgumentExceptionTest(String path, String file, int count) {
            assertThrows(IllegalArgumentException.class, () -> StreamInputOutputUtil.writeRandomNumberInFile(path, file, count));
        }
    }

    @Nested
    class ReadWriteStudent {
        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @ArgumentsSource(WriteSerializedStudentsArgumentsProvider.class)
        public void writeSerializedStudentTest(String path, List<Student> students) {
            StreamInputOutputUtil.writeSerializedStudent(path, students);
        }

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @ArgumentsSource(WriteSerializedStudentsArgumentsProvider.class)
        public void readSerializedStudentTest(String path, List<Student> students) {
            assertEquals(students, StreamInputOutputUtil.readSerializedStudent(path));
        }

        @ParameterizedTest(name = "Tested {index} tasks {displayName}")
        @ArgumentsSource(StudentsByGradeArgumentsProvider.class)
        public void getStudentsByGrade(String filepath, int grade, List<String> lastnameStudents) {
            assertEquals(
                    StreamInputOutputUtil.getStudentsByGrade(StreamInputOutputUtil.readSerializedStudent(filepath), grade),
                    lastnameStudents
            );
        }
    }
}
