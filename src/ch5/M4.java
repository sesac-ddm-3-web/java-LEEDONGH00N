package ch5;

public class M4 {
    public static void main(String[] args) {
        // 1. 리터럴 방식으로 생성 (String Constant Pool에 저장)
        String literal1 = "hello";
        String literal2 = "hello";

        // 2. new 키워드로 인스턴스 생성 (Heap 메모리에 저장)
        String instance1 = new String("hello");
        String instance2 = new String("hello");

        System.out.println("===== 리터럴 비교 =====");
        System.out.println(literal1 == literal2);
        System.out.println(literal1.equals(literal2));
        System.out.println();

        System.out.println("===== 리터럴과 인스턴스 비교 =====");
        System.out.println(literal1 == instance1);
        System.out.println(literal1.equals(instance1));
        System.out.println();

        System.out.println("===== 인스턴스 비교 =====");
        System.out.println(instance1 == instance2);
        System.out.println(instance1.equals(instance2));
        System.out.println();

    }
}
