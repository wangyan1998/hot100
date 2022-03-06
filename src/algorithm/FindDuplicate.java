package algorithm;
//给定一个包含n + 1 个整数的数组nums ，其数字都在[1, n]范围内（包括 1 和 n），
//        可知至少存在一个重复的整数。
//        假设 nums 只有 一个重复的整数 ，返回这个重复的数 。
//        你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
//        1 <= n <= 10^5
//        nums.length == n + 1
//        1 <= nums[i] <= n
//        nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现一次

import java.util.Arrays;

/**
 * @author wy
 * @date 2022/3/5 15:30
 */
public class FindDuplicate {
    /**
     * 排序
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums){
        Arrays.sort(nums);
        for (int i=1;i<nums.length;i++){
            if (nums[i]==nums[i-1]){
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 以target为分界线，设cnt[i]表示数组中小于等于i的数有多少个，假设重复的数是target
     * 在[1,target-1]里,cnt[i]<=i
     * 在[target,n]里，cnt[i]>i
     * 因此，我们只需要查找数组中小于等于mid的数的个数cnt[mid]
     * 如果cnt[mid]>mid,则需要往右边找
     * 如果cnt[mid]<=mid,需要往左边找
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums){
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
