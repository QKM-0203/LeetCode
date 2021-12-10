package stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode-cn.com/problems/sliding-window-maximum/">https://leetcode-cn.com/problems/sliding-window-maximum/</a>
 */
public class MaximumValueOfSlidingWindow {
    /**
     * 思路：采用优先队列（默认小顶堆，可以转变成大顶堆）
     * 时间复杂度：o(n*log n),将一个元素放进优先队列里面的时间复杂度是o(log n)
     * 空间复杂度：o(n)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((pair1, pair2) -> {
            //将优先队列转换成大顶堆
            return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(new int[]{nums[i], i});
        }
        int[] result = new int[n - k + 1];
        //最大的元素
        result[0] = queue.peek()[0];
        for (int i = k; i < n; ++i) {
            queue.offer(new int[]{nums[i], i});
            //最大的元素是滑动窗口左边的元素
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            result[i - k + 1] = queue.peek()[0];
        }
        return result;

    }

    /**
     * 单调队列
     * 时间复杂度:o(n)
     * 空间复杂度:o(k)
     */
    public static int[] monotoneQueue(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        int[] result = new int[n - k + 1];
        result[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            //弹出所有比nums[deque.peekLast()]小的
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            //利用下标可以判断是否在滑动窗口的左侧，换成等于也可以
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }
}
