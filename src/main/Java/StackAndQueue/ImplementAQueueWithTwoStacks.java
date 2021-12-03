package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 思路：两个栈来实现，stackOne是push元素的，将stackOne中的元素出栈放入stackTwo，就可以实现removeHead
 */
public class ImplementAQueueWithTwoStacks {
    private Deque<Integer> stackOne;
    private Deque<Integer> stackTwo;

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
