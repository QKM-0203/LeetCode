package StackAndQueue;

import java.util.*;

/**
 * 思路：两个栈来实现，dataStack是push元素的，minStack是用来存放最小值的，每当push一个元素进如dataStack时，就要与
 * minStack栈顶元素比对看是否小于等于，如果是则push进入minStack,在dataStack中pop元素的时，看pop出来的元素是否和
 * minStack的栈顶元素是否相等，如果是则将minStack也pop。
 */
public class MinStack {
    Deque<Integer> dataStack;
    Deque<Integer> minStack;

    public MinStack() {
        dataStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        dataStack.addLast(x);
        if (minStack.isEmpty()){
            minStack.push(x);
        } else if (minStack.peek() >= x){
            minStack.push(x);
        }
    }

    public void pop() {
        Integer integer = dataStack.removeLast();
        if (Objects.equals(minStack.peek(), integer)) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.getLast();
    }

    public int min() {
        return minStack.getFirst();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());

    }
}
