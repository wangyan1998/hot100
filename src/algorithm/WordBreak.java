package algorithm;
//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
//        注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
//        1 <= s.length <= 300
//        1 <= wordDict.length <= 1000
//        1 <= wordDict[i].length <= 20
//        s 和 wordDict[i] 仅有小写英文字母组成
//        wordDict 中的所有字符串 互不相同


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wy
 * @date 2022/2/23 17:51
 */
public class WordBreak {
    /**
     * 动态规划
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict){
        Set<String> wordDictSet=new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i=1;i<=s.length();i++){
            for (int j=0;j<i;j++){
                if (dp[j]&&wordDictSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
