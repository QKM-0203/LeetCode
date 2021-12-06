package array;
/**
 * 时间复杂度：o(log n)
 * @see <a href="https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/">https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/</a>
 */
public class FindANumberInASortedArray {
    public static int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int result = 0;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                int mid1 = mid;
                while (mid < nums.length && target == nums[mid]) {
                    result++;
                    mid++;
                }
                mid1--;
                while (mid1 > 0 && target == nums[mid1]) {
                    result++;
                    mid1--;
                }
                break;
            }
        }
        return result;
    }
}
