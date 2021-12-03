package array;

public class RemoveNumber {

    /**
     * 思路：双指针，slow指向移除target元素之后的长度，fast用来遍历数组，当nums[fast]不等于target的时候，就让
     * num[slow++] = num[fast]。
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     */
    public static int remove(int[] num, int target) {
        int slow = 0;
        //slow和fast都指向不等于的target的点
        for (int fast = 0; fast < num.length; fast++) {
            if (num[fast] != target) {
                num[slow++] = num[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] num = new int[]{2, 2, 3, 1, 2, 2, 5, 6, 7};
        int remove = remove(num, 2);
        for (int i = 0; i < remove; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
