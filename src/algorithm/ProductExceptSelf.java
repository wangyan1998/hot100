package algorithm;
//给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
//        题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在32 位 整数范围内。
//        请不要使用除法，且在O(n) 时间复杂度内完成此题。
//2 <= nums.length <= 10^5
//        -30 <= nums[i] <= 30
//        保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内

/**
 * @author wy
 * @date 2022/3/4 17:10
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums){
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        int[] res=new int[n];
        left[0]=1;
        right[n-1]=1;
        for (int i=1;i<n;i++){
            left[i]=left[i-1]*nums[i-1];
            right[n-i-1]=right[n-i]*nums[n-i];
        }
        for (int i=0;i<n;i++){
            res[i]=left[i]*right[i];
        }
        return res;
    }
}
