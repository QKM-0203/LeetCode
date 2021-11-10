package array;

public class Dichotomy {
    public static int dichotomyRecursion(int[] array, int i, int j, int target) {
        if (i > j) {
            return -1;
        }
        int mid = (i + j) >> 1;
        int tmp = (array[mid]);
        if (tmp > target) {
            return dichotomyRecursion(array, i, mid - 1, target);
        } else if (tmp < target) {
            return dichotomyRecursion(array, mid + 1, j, target);
        } else {
            return mid;
        }
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
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 61;
        System.out.println(dichotomyRecursion(array, 0, array.length - 1, target));
        System.out.println(dichotomyWhile(array, target));
    }
}
