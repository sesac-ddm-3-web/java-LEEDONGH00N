package ch9.cpu;

public class Main {
    public static void main(String[] args) {
        // 1. 외부 클래스를 통해 정적 중첩 클래스 생성
//        Computer myComputer = new Computer("SAMSUNG", "Galaxy Book");
//        Computer.CPU cpu = myComputer.new CPU(8, 3.2);
//
//        System.out.println("컴퓨터: " + myComputer.getBrand() + " " + myComputer.getModel());
//        System.out.println("CPU 사양: " + cpu.getSpecification());

        // 2. 외부 클래스 인스턴스 없이 직접 정적 중첩 클래스 생성
        Computer.CPU anotherCpu = new Computer.CPU(4, 2.8);
        System.out.println("컴퓨터 외부에서 CPU 생성: " + anotherCpu.getSpecification());
    }
}
