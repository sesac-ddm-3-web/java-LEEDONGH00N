package java_project.data;

public enum OperatorPriority {
    PLUS("+", 2), MINUS("-", 2), MULTIPLY("*", 3), DIVIDE("/", 3),
    L_PAR("(", 1), R_PAR(")", -1);

    private final String symbol;
    private final int priority;

    OperatorPriority(String symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    public int getPriority() { return priority; }

    public static OperatorPriority fromSymbol(String symbol) {
        for (OperatorPriority op : values()) {
            if (op.symbol.equals(symbol)) return op;
        }
        return null;
    }

    public static boolean isOperator(String s) {
        return fromSymbol(s) != null && !s.equals("(") && !s.equals(")");
    }
}
