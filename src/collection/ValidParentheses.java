package collection;

import java.util.Stack;

public class ValidParentheses {

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            }
            else if(c == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                if(stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solver = new ValidParentheses();
        System.out.println("Case 1: (())() -> " + solver.solution("(())()")); // 예상 출력: true
        System.out.println("Case 2: )()( -> " + solver.solution(")()("));   // 예상 출력: false
        System.out.println("Case 3: (() -> " + solver.solution("(("));    // 예상 출력: false
    }
}