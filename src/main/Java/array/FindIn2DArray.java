package array;

import java.util.ArrayList;

/**
 * @see <a href="https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/">https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/</a>
 */
public class FindIn2DArray {
    /**
     * 思路：先从第一排找，利用二分查找如果找到直接返回，没有找到利用返回的下标（找到比target小的列）
     * 同理从第一列找利用二分查找如果找到直接返回，没有找到利用返回的下标（找到比target小的行）
     * 然后在行列集合里面找target,如果找到返回true.
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int lines = dichotomyWhile(matrix[0], target);
        ArrayList<Integer> line = new ArrayList<>();
        ArrayList<Integer> column = new ArrayList<>();
        //防止返回的下标和target一致误以为该值存在
        if (lines == 10000) {
            return true;
        }
        for (int i = 1; i < lines; i++) {
            line.add(i);
        }
        System.out.println(line);
        int[] ints = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            ints[i] = matrix[i][0];
        }
        int columns = dichotomyWhile(ints, target);
        if (columns == 10000) {
            return true;
        }
        for (int i = 1; i < columns; i++) {
            column.add(i);
        }
        System.out.println(column);
        for (Integer value : column) {
            for (Integer integer : line) {
                if (matrix[value][integer] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int dichotomyWhile(int[] array, int target) {
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            int tmp = array[mid];
            if (tmp < target) {
                i = mid + 1;
            } else if (tmp > target) {
                j = mid - 1;
            } else
                return 10000;
        }
        return i;
    }


    public static void main(String[] args) {
        int[][] ints = {{1, 1}};
        System.out.println(findNumberIn2DArray(ints, 0));
    }
}
