package algorithm;
//给你一个 无重复元素 的整数数组candidates 和一个目标整数target，
//        找出candidates中可以使数字和为目标数target的所有不同组合 ，
//        并以列表形式返回。你可以按 任意顺序 返回这些组合。
//        candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少
//        一个数字的被选数量不同，则两种组合是不同的。
//        对于给定的输入，保证和为target 的不同组合数少于 150 个。

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2022/2/16 16:31
 */
public class CombinationSum {
    /**
     * 回溯法
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        backtrack(candidates, target, res, cur, 0);
        return res;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> cur, int idx) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            cur.add(candidates[i]);
            backtrack(candidates, target - candidates[i], res, cur, i);
            cur.remove(cur.size() - 1);
        }
    }

    /**
     * 官方回溯题解
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }
}
