package java_project.device;

import java_project.calculate.CalculatorEngine;
import java_project.converter.ExpressionConverter;
import java_project.data.CalculatorData;
import java_project.data.TaskType;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculatorDevice {

    private final ExpressionConverter converter;
    private final CalculatorEngine engine;
    private final Map<Integer, CalculatorData> dataMap = new LinkedHashMap<>();
    private int id = 1;

    public CalculatorDevice(ExpressionConverter expressionConverter, CalculatorEngine calculatorEngine) {
        this.converter = expressionConverter;
        this.engine = calculatorEngine;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            TaskType task = TaskType.from(scanner.nextInt());
            scanner.nextLine();
            switch (task) {
                case LIST -> showHistory();
                case CALCULATE -> {
                    System.out.print("수식 입력: ");
                    calculate(scanner.nextLine());
                }
                case EXIT -> {
                    System.out.println("종료합니다.");
                    return;
                }
            }
        }
    }

    private void calculate(String expr) {
        int result = engine.calculate(converter.convert(expr));
        System.out.println(result);
        dataMap.put(id++, CalculatorData.create(expr, String.valueOf(result)));
    }

    private void printMenu() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
    }

    private void showHistory() {
        if (dataMap.isEmpty()) {
            System.out.println("계산 이력이 없습니다.");
            return;
        }

        for (Map.Entry<Integer, CalculatorData> entry : dataMap.entrySet()) {
            CalculatorData data = entry.getValue();
            System.out.println(data.toString());
        }
    }
}
