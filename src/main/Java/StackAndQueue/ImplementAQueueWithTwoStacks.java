package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 思路：两个栈来实现，stackOne是push元素的，将stackOne中的元素出栈放入stackTwo，就可以实现removeHead
 */
public class ImplementAQueueWithTwoStacks {
    private final Deque<Integer> stackOne;
    private final Deque<Integer> stackTwo;

    public ImplementAQueueWithTwoStacks() {
        stackOne = new LinkedList<>();
        stackTwo = new LinkedList<>();
    }

    public void appendTail(int value) {
        stackOne.addLast(value);
    }

    public int deleteHead() {
        if (stackTwo.isEmpty()) {
            if (stackOne.isEmpty()) {
                return -1;
            } else {
                while (!stackOne.isEmpty()) {
                    stackTwo.addLast(stackOne.removeLast());
                }
            }
        }
        return stackTwo.removeLast();
    }
}

class MyQueue {
    private final Deque<Integer> stackOne;
    private final Deque<Integer> stackTwo;


    public MyQueue() {
        stackOne = new LinkedList<>();
        stackTwo = new LinkedList<>();
    }

    public void push(int x) {
        stackOne.push(x);
    }

    public int pop() {
        return pushStackTwo();
    }

    public int peek() {
        return pushStackTwo();
    }

    public boolean empty() {
        return stackOne.isEmpty() && stackTwo.isEmpty();
    }

    public int pushStackTwo() {
        if (stackTwo.isEmpty()) {
            if (stackOne.isEmpty()) {
                return -1;
            } else {
                while (!stackOne.isEmpty()) {
                    stackTwo.push(stackOne.pop());
                }
            }
        }
        return stackTwo.peek();
    }
}

class MyStack {
    private final Deque<Integer> stackOne;

    public MyStack() {
        stackOne = new LinkedList<>();
    }

    public void push(int x) {
        stackOne.push(x);
    }

    public int pop() {
        return stackOne.pop();
    }

    public int top() {
        return stackOne.peek();
    }

    public boolean empty() {
        return stackOne.isEmpty();
    }
}