package array;

/**
 * @see <a href="https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/">https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/</a>
 */
public class DuplicateNumberInArray {
    /**
     * 思路：根据数组的下标来做，一个下标对应多个值
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i) {
                i++;
            } else if (nums[nums[i]] == nums[i]) {
                return nums[i];
            } else {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
