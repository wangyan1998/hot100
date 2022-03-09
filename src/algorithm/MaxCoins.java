package algorithm;
//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组nums中。
//        现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
//        这里的 i - 1 和 i + 1 代表和i相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，
//        那么就当它是一个数字为 1 的气球。
//        求所能获得硬币的最大数量。
import java.util.Arrays;

/**
 * @author wy
 * @date 2022/3/7 10:01
 */
public class MaxCoins {
    /**
     * 把打气球转换成添加气球，然后用分治法，找到最大的硬币数
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            val[i] = nums[i - 1];
        }
        int[][] rec = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(rec[i], -1);
        }
        return solve(rec, val, 0, n + 1);
    }

    public int solve(int[][] rec, int[] val, int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        if (rec[left][right] != -1) {
            return rec[left][right];
        }
        for (int i = left+1; i < right; i++) {
            int sum = val[left] * val[i] * val[right];
            sum += solve(rec, val, left, i) + solve(rec, val, i, right);
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        return rec[left][right];
    }
}
