package algorithm;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的
//        开始位置和结束位置。
//        如果数组中不存在目标值 target，返回[-1, -1]。
//        进阶：
//        你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？

/**
 * @author wy
 * @date 2022/2/16 9:51
 */
public class SearchRange {
    /**
     * 二分查找加一次遍历
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if ((mid == 0 && nums[mid] == target) || (nums[mid] == target && nums[mid - 1] != target)) {
                res[0] = mid;
                break;
            }
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (res[0] == -1) {
            return res;
        }
        for (int i = res[0]; i < nums.length; i++) {
            if (nums[i] == target) {
                res[1] = i;
            } else {
                break;
            }
        }
        return res;
    }


    public int[] searchRange1(int[] nums, int target) {
        int[] res = {-1, -1};
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if ((mid == 0 && nums[mid] == target) || (nums[mid] == target && nums[mid - 1] != target)) {
                res[0] = mid;
                break;
            }
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if ((mid == nums.length - 1 && nums[mid] == target) || (nums[mid] == target && nums[mid + 1] != target)) {
                res[1] = mid;
                break;
            }
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
