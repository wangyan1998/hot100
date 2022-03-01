package algorithm;
//给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），
//        并返回该子数组所对应的乘积。
//        测试用例的答案是一个32-位 整数。
//        子数组 是数组的连续子序列。

/**
 * @author wy
 * @date 2022/3/1 15:55
 */
public class MaxProduct {
    /**
     * 动态规划问题
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxF = new int[n];
        int[] minF = new int[n];
        System.arraycopy(nums, 0, maxF, 0, n);
        System.arraycopy(nums, 0, minF, 0, n);
        for (int i=1;i<n;i++){
            maxF[i]=Math.max(maxF[i-1]*nums[i],Math.max(minF[i-1]*nums[i],nums[i]));
            minF[i]=Math.min(maxF[i-1]*nums[i],Math.min(minF[i-1]*nums[i],nums[i]));
        }
        int res=maxF[0];
        for (int i=1;i<n;i++){
            res=Math.max(res,maxF[i]);
        }
        return res;
    }
}
