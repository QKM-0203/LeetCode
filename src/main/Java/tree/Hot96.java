package tree;

/**
 * 多少种不同的二叉搜索树
 */
public class Hot96 {
    public int numTrees(int n) {
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
