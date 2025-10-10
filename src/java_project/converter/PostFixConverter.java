package java_project.converter;

import java_project.data.OperatorPriority;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostFixConverter implements ExpressionConverter {

    private String normalizeUnaryMinus(String s) {
        String expr = s.replaceAll("\\s+", "");
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '-' && (i == 0 || "(+-*/".indexOf(expr.charAt(i - 1)) >= 0)) {
                out.append('0');
            }
            out.append(c);
        }
        return out.toString();
    }

    private List<String> tokenize(String expr) {
        List<String> tokens = new ArrayList<>();
        Matcher m = Pattern.compile("\\d+(?:\\.\\d+)?|[()+\\-*/]").matcher(expr);
        while (m.find()) tokens.add(m.group());
        return tokens;
    }

    public String convert(String expression) {
        String expr = normalizeUnaryMinus(expression);
        List<String> tokens = tokenize(expr);

        Deque<String> ops = new ArrayDeque<>();
        List<String> out = new ArrayList<>();

        for (String t : tokens) {
            OperatorPriority op = OperatorPriority.fromSymbol(t);

            if (op == null) {
                out.add(t);
            } else if ("(".equals(t)) {
                ops.push(t);
            } else if (")".equals(t)) {
                while (!ops.isEmpty() && !"(".equals(ops.peek())) out.add(ops.pop());
                if (ops.isEmpty()) throw new IllegalArgumentException("괄호 불일치");
                ops.pop();
            } else {
                while (!ops.isEmpty() && OperatorPriority.isOperator(ops.peek())) {
                    OperatorPriority top = OperatorPriority.fromSymbol(ops.peek());
                    if (top.getPriority() >= op.getPriority()) out.add(ops.pop());
                    else break;
                }
                ops.push(t);
            }
        }
        while (!ops.isEmpty()) {
            if ("(".equals(ops.peek())) throw new IllegalArgumentException("괄호 불일치");
            out.add(ops.pop());
        }
        return String.join(" ", out);
    }
}
