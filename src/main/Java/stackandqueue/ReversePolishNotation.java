package stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @see <a href="https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/">https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/</a>
 * 时间复杂度：o(n)
 * 空间复杂度：o(n)
 */
public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Object> stack = new ArrayDeque<>();
        HashMap<String, Integer> charMap = new HashMap<String, Integer>();
        charMap.put("*",1);
        charMap.put("+",1);
        charMap.put("/",1);
        charMap.put("-",1);
        for (String token : tokens) {
            if (charMap.get(token) != null) {
                Integer pop1 = (Integer) stack.pop();
                Integer pop2 = (Integer) stack.pop();
                switch (token) {
                    case "*" -> stack.push(pop2 * pop1);
                    case "/" -> stack.push(pop2 / pop1);
                    case "+" -> stack.push(pop2 + pop1);
                    default -> stack.push(pop2 - pop1);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return (Integer) stack.pop();
    }
}
