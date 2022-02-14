package algorithm;
import java.util.*;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
//1 <= n <= 8
/**
 * @author wy
 * @date 2022/2/14 13:38
 */
public class GenerateParenthesis {
    /**
     * 这是经典的回溯法的题目
     * 回溯法的便利在于自己调用自己试探存在的各种情况
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n){
        List<String> ans =new ArrayList<String>();
        backtrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }
    public void backtrack(List<String> ans,StringBuilder cur,int open,int close,int max){
        if(cur.length()==max*2){
            ans.add(cur.toString());
            return;
        }
        if(open<max){
            cur.append('(');
            backtrack(ans,cur,open+1,close,max);
            cur.deleteCharAt(cur.length()-1);
        }
        if (close<open){
            cur.append(')');
            backtrack(ans,cur,open,close+1,max);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
