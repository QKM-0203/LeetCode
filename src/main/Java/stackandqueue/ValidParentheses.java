package stackandqueue;

import java.util.Stack;

/**
 * @see <a href="https://leetcode-cn.com/problems/valid-parentheses/">https://leetcode-cn.com/problems/valid-parentheses/</a>
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 == 0) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (c == '}') {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
        return false;
    }
}
