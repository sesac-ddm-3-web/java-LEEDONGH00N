package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Practice3 {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alice", 25),
                new User("Bob", 30),
                new User("Charlie", 22),
                new User("David", 28)
        );
        List<String> userNames = users.stream()
                .filter(user -> user.getAge()>= 25)
                .map(User::getName)
                .toList();
        System.out.println(userNames); // [Alice, Bob, David]
    }
}

