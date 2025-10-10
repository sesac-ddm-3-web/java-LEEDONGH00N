package java_project.validator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionValidator {

    public static void validate(String expression) {
        String expr = normalizeUnaryMinus(expression);  // 1) 공백 제거 + 단항- 보정
        List<String> tokens = tokenizeStrict(expr);     // 2) 토큰화 + 허용문자 검증
        checkGrammar(tokens);                           // 3) 괄호/연산자 위치/균형 검증
    }

    // ---- 내부 구현 ----

    private static String normalizeUnaryMinus(String s) {
        if (s == null) throw new IllegalArgumentException("입력이 null입니다.");
        String expr = s.replaceAll("\\s+", "");
        if (expr.isEmpty()) throw new IllegalArgumentException("빈 수식입니다.");
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '-' && (i == 0 || "(+-*/".indexOf(expr.charAt(i - 1)) >= 0)) {
                out.append('0'); // -x -> 0-x, (-x)->(0-x)
            }
            out.append(c);
        }
        return out.toString();
    }

    /** 정규식으로 엄격하게 토큰화. 중간에 인식 불가 문자열이 있으면 예외 */
    private static List<String> tokenizeStrict(String expr) {
        List<String> tokens = new ArrayList<>();
        Matcher m = Pattern.compile("\\d+|[()+\\-*/]").matcher(expr);
        int pos = 0;
        while (m.find()) {
            if (m.start() != pos) {
                throw new IllegalArgumentException("유효하지 않은 입력: '" + expr.substring(pos, m.start()) + "'");
            }
            tokens.add(m.group());
            pos = m.end();
        }
        if (pos != expr.length()) {
            throw new IllegalArgumentException("유효하지 않은 입력: '" + expr.substring(pos) + "'");
        }
        return tokens;
    }

    /** 문법 검증: 괄호/연산자 위치/암묵곱셈/피연산자 균형 */
    private static void checkGrammar(List<String> tokens) {
        enum Prev { NONE, NUM, OP, LPAR, RPAR }
        Prev prev = Prev.NONE;

        // 피연산자-연산자 균형은 "후위식 방출 시" 알 수 있지만,
        // 여기선 간단히 스택 없는 카운팅으로 보수적 검증 수행
        // (숫자 만날 때 +1, 연산자 방출될 때 -1을 "방출 시점"에 해야 정확)
        // 정확도를 높이려면 간단 Shunting Yard로 방출하면서 검사하는 방식 권장.
        // 아래는 Shunting Yard-lite로 구현.
        Deque<String> ops = new ArrayDeque<>();
        int balance = 0; // RPN 기준 숫자(+1) / 이항연산자 방출(-1)

        for (String t : tokens) {
            if (isNumber(t)) {
                if (prev == Prev.NUM || prev == Prev.RPAR)
                    throw new IllegalArgumentException("연산자 없이 숫자가 연속되었습니다.");
                balance++;               // 숫자 하나 추가
                prev = Prev.NUM;
            } else if ("(".equals(t)) {
                if (prev == Prev.NUM || prev == Prev.RPAR)
                    throw new IllegalArgumentException("암묵적 곱셈은 지원하지 않습니다: 숫자/')' 뒤 '('");
                ops.push(t);
                prev = Prev.LPAR;
            } else if (")".equals(t)) {
                while (!ops.isEmpty() && !"(".equals(ops.peek())) {
                    ops.pop();
                    balance--;           // 이항 연산자 하나 방출
                    if (balance < 1) throw new IllegalArgumentException("피연산자가 부족합니다.");
                }
                if (ops.isEmpty()) throw new IllegalArgumentException("괄호 불일치");
                ops.pop(); // '(' 제거
                prev = Prev.RPAR;
            } else { // 연산자
                if (prev == Prev.NONE || prev == Prev.OP || prev == Prev.LPAR)
                    throw new IllegalArgumentException("연속 연산자 또는 잘못된 위치의 연산자입니다: " + t);
                while (!ops.isEmpty() && isOperator(ops.peek())) {
                    // +,- : 1,  *,/ : 2  (좌결합) — 간단 우선순위
                    int top = prec(ops.peek()), cur = prec(t);
                    if (top >= cur) {
                        ops.pop();
                        balance--;
                        if (balance < 1) throw new IllegalArgumentException("피연산자가 부족합니다.");
                    } else break;
                }
                ops.push(t);
                prev = Prev.OP;
            }
        }
        while (!ops.isEmpty()) {
            String top = ops.pop();
            if ("(".equals(top)) throw new IllegalArgumentException("괄호 불일치");
            // 연산자 방출
            balance--;
            if (balance < 1) throw new IllegalArgumentException("피연산자가 부족합니다.");
        }
        if (balance != 1) throw new IllegalArgumentException("잘못된 식(피연산자/연산자 불균형)");
    }

    private static boolean isNumber(String t) { return t.chars().allMatch(Character::isDigit); }
    private static boolean isOperator(String t) { return "+-*/".contains(t); }
    private static int prec(String op) { return (op.equals("+")||op.equals("-")) ? 1 : 2; }
}
