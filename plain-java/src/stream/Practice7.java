package stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

public class Practice7 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("James", "개발팀", 5500),
                new Employee("Robert", "개발팀", 6000),
                new Employee("Maria", "기획팀", 5800),
                new Employee("Linda", "기획팀", 6200),
                new Employee("David", "인사팀", 5300)
        );
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
        System.out.println(avgSalaryByDept);// {인사팀=5300.0, 개발팀=5750.0, 기획팀=6000.0}
    }
}
