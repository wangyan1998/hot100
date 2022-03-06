package algorithm;
//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//        完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，
//        其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
//        1 <= n <= 10^4

/**
 * @author wy
 * @date 2022/3/5 10:58
 */
public class NumSquares {
    /**
     * 动态规划：可以拆解成规模更小的子问题求解
     * 转移方程：f[i]=1+min{j=1->sqrt(i)}f[i-j*j]
     *边界：f[0]=0，但实际上0不可得到
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }
}
