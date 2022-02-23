package algorithm;
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//        请你设计并实现时间复杂度为O(n) 的算法解决此问题。
//        0 <= nums.length <= 10^5
//        -10^9 <= nums[i] <= 10^9

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wy
 * @date 2022/2/23 17:04
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums){
        Set<Integer> num_set=new HashSet<>();
        for (int num:nums){
            num_set.add(num);
        }
        int longestStreak=0;
        for (int num:num_set){
            if (!num_set.contains(num-1)){
                int currentNum=num;
                int currentStreak=1;
                while (num_set.contains(currentNum+1)){
                    currentNum+=1;
                    currentStreak+=1;
                }
                longestStreak=Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
}
