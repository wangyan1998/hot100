package algorithm;
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊n/2⌋的元素。
//        你可以假设数组是非空的，并且给定的数组总是存在多数元素。


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2022/3/1 17:22
 */
public class MajorityElement {
    /**
     * 排序
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length / 2;
        for (int num : nums) {
            int x=map.getOrDefault(num,0)+1;
            if (x > n) {
               return num;
            }
            map.put(num,x);
        }
        return 0;
    }
}
