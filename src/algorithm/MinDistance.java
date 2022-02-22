package algorithm;
//给你两个单词word1和word2，请返回将word1转换成word2所使用的最少操作数。
//        你可以对一个单词进行如下三种操作：
//        插入一个字符
//        删除一个字符
//        替换一个字符


/**
 * @author wy
 * @date 2022/2/20 16:22
 */
public class MinDistance {
    /**
     * 动态规划
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1,String word2){
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<n+1;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                int left=dp[i][j-1]+1;
                int down=dp[i-1][j]+1;
                int left_down=dp[i-1][j-1];
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    left_down++;
                }
                dp[i][j]=Math.min(Math.min(left,down),left_down);
            }
        }
        return dp[m][n];
    }
}
