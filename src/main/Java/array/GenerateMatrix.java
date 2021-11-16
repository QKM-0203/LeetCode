package array;

//spiral matrix print
public class GenerateMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int up = 0, right = n - 1, down = n - 1, left = 0;
        int rounds = n, number = 1;
        while (rounds > 1) {
            for (int j = n - rounds - up; j < rounds - 1 + up; j++) {
                nums[up][j] = number;
                number++;
            }
            up++;
            for (int i = n - right - 1; i < right; i++) {
                nums[i][right] = number;
                number++;
            }
            right--;
            for (int j = down; j > n - down - 1; j--) {
                nums[down][j] = number;
                number++;
            }
            down--;
            for (int i = n - left - 1; i > n - rounds - left; i--) {
                nums[i][left] = number;
                number++;
            }
            left++;
            rounds = rounds - 2;
        }
        if (n % 2 != 0) {
            nums[n / 2][n / 2] = n * n;
        }
        return nums;
    }

    private static void print(int[][] nums) {
        for (int[] num : nums) {
            for (int i : num) {
                System.out.printf("%2d ", i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GenerateMatrix.print(GenerateMatrix.generateMatrix(5));
    }
}
