package java_project.calculate;

import java_project.data.OperatorPriority;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostFixEngine implements CalculatorEngine{

    public int calculate(String rpnString) {
        if (rpnString == null || rpnString.isBlank())
            throw new IllegalArgumentException("빈 후위식입니다.");
        Deque<Integer> st = new ArrayDeque<>();
        for (String t : rpnString.trim().split("\\s+")) {
            if (!OperatorPriority.isOperator(t)) {
                st.push(Integer.parseInt(t));
            } else {
                if (st.size() < 2) throw new IllegalArgumentException("잘못된 식(피연산자 부족)");
                double b = st.pop(), a = st.pop();
                switch (t) {
                    case "+": st.push((int) (a + b)); break;
                    case "-": st.push((int) (a - b)); break;
                    case "*": st.push((int) (a * b)); break;
                    case "/":
                        if (b == 0.0) throw new ArithmeticException("0으로 나눌 수 없습니다");
                        st.push((int) (a / b)); break;
                    default: throw new IllegalArgumentException("지원하지 않는 연산자: " + t);
                }
            }
        }
        if (st.size() != 1) throw new IllegalArgumentException("잘못된 식(남는 피연산자)");
        return st.pop();
    }

}
