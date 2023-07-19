package chapter10.ArgumentsProviders;

import book.chapter10.model.Student;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.List;
import java.util.stream.Stream;

public class WriteSerializedStudentsArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("data/students.dat", List.of(
                        new Student(1, "Doe", List.of(10, 7, 8, 2, 6, 9, 3)),
                        new Student(2, "Sidorov", List.of(1, 5, 2, 6, 10, 5, 3, 6)),
                        new Student(3, "Petrov", List.of(2, 6, 7, 10, 5, 4, 9, 3, 1)),
                        new Student(4, "Ahmatov", List.of(3, 7, 5, 6, 1, 4, 2, 8, 9)),
                        new Student(5, "Bush", List.of(9, 3, 6, 8, 1, 10, 4, 7, 5)),
                        new Student(6, "Trump", List.of(9, 1, 10, 8, 3, 4, 7, 5, 2)),
                        new Student(7, "Baiden", List.of(8, 8, 8, 9, 8, 9, 8, 8, 10))
                )),
                Arguments.of("data/students1.dat", List.of(
                        new Student(8, "Hunt", List.of(8, 6, 5, 7, 9)),
                        new Student(9, "Richardson", List.of(9, 6, 10, 10, 10, 9, 5, 10, 7)),
                        new Student(10, "Jordan", List.of(7, 8, 10, 9, 10, 6)),
                        new Student(11, "Houston", List.of(5, 8, 6, 7, 10)),
                        new Student(12, "Edwards", List.of(6, 9, 5, 6, 10, 5, 9, 10, 7)),
                        new Student(13, "Howard", List.of(9, 7, 6, 9, 10, 10, 10, 8)),
                        new Student(14, "Ruiz", List.of(5, 5, 5, 7, 8, 9, 9, 9, 10))
                ))
        );
    }
}
