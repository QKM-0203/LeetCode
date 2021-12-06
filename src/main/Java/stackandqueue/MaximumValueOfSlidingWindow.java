package stackandqueue;

import java.util.Comparator;
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
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                //将优先队列转换成大顶堆
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
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
}
