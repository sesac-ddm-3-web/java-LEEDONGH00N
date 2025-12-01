package java_project.data;

public class CalculatorData {

    private String expression;
    private String result;

    public CalculatorData(String expression, String result) {
        this.expression = expression;
        this.result = result;
    }

    @Override
    public String toString() {
        return expression + " = " + result;
    }

    public static CalculatorData create(String expression, String result){
        return new CalculatorData(expression, result);
    }
}
