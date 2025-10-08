package practice;

import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }

    @Override
    public String toString() {
        return name + "(" + score + "점)";
    }
}

public class StudentManager {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("김철수", 85),
                new Student("이영희", 92),
                new Student("박민수", 78),
                new Student("정지원", 95),
                new Student("최유진", 88)
        );

        // TODO 1: 80점 이상 학생들만 필터링하여 출력

        List<Student> result = students
                .stream()
                .filter(s -> s.getScore() >= 80)
                .toList();
        for (Student student : result) {
            System.out.println(student.getName());
        }

        // TODO 2: 전체 학생 평균 점수 계산 (Optional<Double> 활용)


        // TODO 3: 점수 기준 내림차순 정렬 후 출력


        // TODO 4: 이름으로 학생 찾기 (Optional 반환)
        // "박민수" 찾기 -> 있으면 점수 출력, 없으면 "학생을 찾을 수 없습니다" 출력

    }
}