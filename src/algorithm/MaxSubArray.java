package algorithm;
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//        子数组 是数组中的一个连续部分。
//1 <= nums.length <= 10^5
//        -10^4 <= nums[i] <= 10^4

import java.util.Arrays;

/**
 * @author wy
 * @date 2022/2/18 18:02
 */
public class MaxSubArray {
    /**
     * 非常典型的动态规划的题目
     * 设dp[i]是以nums[i]结尾的子数组最大和
     * 转移方程为dp[i]=max(dp[i-1]+nums[i],nums[i])
     * 边界是dp[0]=nums[0]
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
