package array;

// 时间复杂度：O(n)
// 空间复杂度：O(1)
//移除数组元素，要求不使用额外数组空间，元素的相对位置可以改变
public class RemoveNumber {

    public static int remove(int[] num,int target) {
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
        int[] num = new int[]{2,2,3,1,2,2,5,6,7};
        int remove = remove(num, 2);
        for (int i = 0; i < remove; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
