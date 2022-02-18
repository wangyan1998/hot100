package algorithm;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wy
 * @date 2022/2/18 14:58
 */
public class Permute {
    /**
     * 典型的回溯法题目
     * 通过标记数组进行选择回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int n = nums.length;
        boolean[] visit = new boolean[n];
        backtrack(nums, n, 0, visit, res, cur);
        return res;
    }

    public void backtrack(int[] nums, int n, int pos, boolean[] visit, List<List<Integer>> res, List<Integer> cur) {
        if (pos == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visit[i] == false) {
                cur.add(nums[i]);
                visit[i] = true;
                backtrack(nums, n, pos + 1, visit, res, cur);
                cur.remove(cur.size() - 1);
                visit[i] = false;
            }
        }
    }

    /**
     * 不使用标记数组，通过将cur进行分割，前半部分是已经使用的，后半部分是没使用过的
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int num : nums) {
            cur.add(num);
        }
        int n = nums.length;
        backtrack1(nums, n, 0, res, cur);
        return res;
    }

    public void backtrack1(int[] nums, int n, int first, List<List<Integer>> res, List<Integer> cur) {
        if (first == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = first; i < n; i++) {
            Collections.swap(cur, first, i);
            backtrack1(nums, n, first + 1, res, cur);
            Collections.swap(cur, first, i);
        }
    }
}
