package ch8.shape_calculator;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 5.0);

        System.out.printf("원의 넓이: %.2f\n", circle.calculateArea());
        System.out.printf("원의 둘레: %.2f\n", circle.calculatePerimeter());

        System.out.printf("직사각형의 넓이: %.1f\n", rectangle.calculateArea());
        System.out.printf("직사각형의 둘레: %.1f\n", rectangle.calculatePerimeter());
    }
}
