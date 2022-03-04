package algorithm;
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//        请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//        1 <= k <= nums.length <= 10^4
//        -10^4 <= nums[i] <= 10^4

import sort.QuickSort;

import java.util.Arrays;


/**
 * @author wy
 * @date 2022/3/4 10:09
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n - k];
    }

    public int findKthLargest1(int[] nums, int k) {
        int n = nums.length;
        QuickSort sort=new QuickSort();
        sort.quickSort(nums, 0, n - 1);
        return nums[n-k];
    }
}
