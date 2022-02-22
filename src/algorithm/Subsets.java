package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2022/2/22 10:54
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        int n=nums.length;
        backtrack(nums,0,n,res,cur);
        return res;
    }
    public void backtrack(int[] nums,int i,int n,List<List<Integer>> res,List<Integer> cur){
        if(i==n){
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        backtrack(nums,i+1,n,res,cur);
        cur.remove(cur.size()-1);
        backtrack(nums,i+1,n,res,cur);
    }


    public List<List<Integer>> subsets1(int[] nums){
        List<Integer> t=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        for(int mask=0;mask<(1<<n);++mask){
            t.clear();
            for (int i=0;i<n;i++){
                if ((mask & (1<<i))!=0){
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }

    /**
     * 更好的回溯方法
     */
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}
