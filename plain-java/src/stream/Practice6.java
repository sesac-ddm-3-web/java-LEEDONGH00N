package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class Student {
    private String name;
    private List<String> courses; // 수강하는 과목 리스트

    public Student(String name, List<String> courses) {
        this.name = name;
        this.courses = courses;
    }

    public List<String> getCourses() {
        return courses;
    }
}

public class Practice6 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", Arrays.asList("Java", "Math")),
                new Student("Bob", Arrays.asList("Math", "English")),
                new Student("Charlie", Arrays.asList("Java", "History"))
        );

        List<String> allCourses = students.stream()
                .flatMap(student -> student.getCourses().stream())
                .distinct()
                .toList();

        System.out.println(allCourses); // [Java, Math, Math, English, Java, History]

    }
}
