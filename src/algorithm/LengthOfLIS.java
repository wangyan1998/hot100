package algorithm;
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//        子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
//        例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

/**
 * @author wy
 * @date 2022/3/6 17:04
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums){
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=1;
        int res=1;
        for (int i=1;i<n;i++){
            int max=0;
            for (int j=0;j<i;j++){
                if (nums[j]<nums[i]){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=max+1;
            res=Math.max(res,dp[i]);
        }
        return res;
    }

}
