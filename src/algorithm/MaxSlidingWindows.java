package algorithm;
//给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
//        你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
//        返回 滑动窗口中的最大值 。
//        1 <= nums.length <= 10^5
//        -10^4 <= nums[i] <= 10^4
//        1 <= k <= nums.length

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wy
 * @date 2022/3/4 17:19
 */
public class MaxSlidingWindows {
    public int[] maxSlidingWindows(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] < i - k + 1) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
