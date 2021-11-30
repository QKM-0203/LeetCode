package twopointers;

/**
 * 盛水最多的容器
 */
public class ContainerWithTheMostWater {
    public int maxArea(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                res = Math.max(height[i] * (j - i), res);
                i++;
            } else {
                res = Math.max(height[j] * (j - i), res);
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
