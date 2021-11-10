package array;

import java.util.Arrays;

public class SumOfSquaresOfArrays {

    //快排
    private void fastSort(int left, int right, int[] nums) {
        int key = nums[left], start = left, end = right;
        while (left < right) {
            while (key <= nums[right] && left < right) {
                right--;
            }
            while (key >= nums[left] && left < right) {
                left++;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (left == right) {
                int temp = nums[left];
                nums[left] = key;
                nums[start] = temp;
            }
        }
        if (start < left) {
            //写成left就是stackOverflow
            fastSort(start, left - 1, nums);
        }
        if (left < end) {
            //写成left就是stackOverflow
            fastSort(left + 1, end, nums);
        }
    }

    //先平方在排序 时间复杂度=o(n + nlogn)
    private int[] squares(int[] nums) {
        if (nums.length == 0 || nums[0] >= 0) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        fastSort(0, nums.length - 1, nums);
        return nums;
    }

    //学会分析问题，因为已经是排好序的了，那莫最大值肯定是在最两边,双指针解法。时间复杂度o(n)
    private int[] twoPoints(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1, end = nums.length - 1;
        while (left < right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[end--] = nums[left] * nums[left];
                left++;
            } else {
                result[end--] = nums[right] * nums[right];
                right--;
            }
        }
        result[end] = nums[left] * nums[left];
        return result;
    }

    public static void main(String[] args) {
        SumOfSquaresOfArrays sumOfSquaresOfArrays = new SumOfSquaresOfArrays();
        int[] nums = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sumOfSquaresOfArrays.squares(nums)));
        System.out.println(Arrays.toString(sumOfSquaresOfArrays.twoPoints(nums)));
    }
}
