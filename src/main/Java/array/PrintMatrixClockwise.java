package array;

import java.util.Arrays;

//时间复杂度o(n*m)
//空间复杂度o(1),不算那个返回的数组的话

/**
 * @see <a href="https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/">https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/</a>
 */
public class PrintMatrixClockwise {

    private static int[] print(int[][] nums) {
        if (nums.length == 0){
            return new int[0];
        }
        int top = 0, right = nums[0].length - 1, down = nums.length - 1, left = 0, number = 0;
        int[] result = new int[nums.length * nums[0].length];
        while (left <= right && top <= down) {
            for (int column = left; column <= right; column++) {
                result[number++] = nums[top][column];
            }
            for (int row = top + 1; row <= down; row++) {
                result[number++] = nums[row][right];
            }
            //只剩向左和向下
            if (left < right && top < down) {
                for (int column = right - 1; column > left; column--) {
                    result[number++] = nums[down][column];
                }
                for (int row = down; row > top; row--) {
                    result[number++] = nums[row][left];
                }
            }
            top++;
            left++;
            down--;
            right--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{};
        System.out.println(Arrays.toString(PrintMatrixClockwise.print(nums)));
    }
}
