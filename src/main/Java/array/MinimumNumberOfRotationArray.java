package array;

/**
 * @see <a href="https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/submissions/">https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/submissions/</a>
 */
public class MinimumNumberOfRotationArray {
    /**
     * 思路：因为原来是有序的，所以就是找到分节点，后面的数比前面的数小就是分界点。
     */
    public static int minArray(int[] numbers) {
        int key = 1;
        for (int i = 0; i < numbers.length; ) {
            if (i < numbers.length - 1 && numbers[i + 1] >= numbers[i]) {
                i++;
                key++;
            } else {
                break;
            }
        }
        //全部是递增的返回第一个数
        if (key == numbers.length) {
            return numbers[0];
        } else {
            return numbers[key];
        }
    }
}
