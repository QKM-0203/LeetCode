package array;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode-cn.com/problems/minimum-size-subarray-sum/">https://leetcode-cn.com/problems/minimum-size-subarray-sum/</a>
 */
public class MinSubArrayLen {
    //has three point not pass,because of when equal to and greater than, take first
    public static int minSubArrayLenFail(int target, int[] nums) {
        Arrays.sort(nums);
        int index = nums.length - 1;
        int result = 0;
        while (index >= 0) {
            if (target > nums[index]) {
                result++;
                target = target - nums[index];
            } else if (target <= nums[index]) {
                result++;
                return result;
            }
            index--;
        }
        return 0;
    }

    //continuity（连续），重要的是"连续",求的是连续的所以就是可以一节一节的取。（滑动窗口）
    //时间复杂度o(n)
    private static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0, in = 0, out = 0;
        while (in < nums.length) {
            sum += nums[in];
            while (sum >= target) {
                result = Math.min(result, in - out + 1);
                sum -= nums[out++];
            }
            in++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};
        System.out.println(minSubArrayLen(213, nums));
    }
}
