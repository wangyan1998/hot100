package algorithm;
//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//        m == matrix.length
//        n == matrix[i].length
//        1 <= m, n <= 300
//        matrix[i][j] 为 '0' 或 '1'


/**
 * @author wy
 * @date 2022/3/4 11:29
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix){
        int r=matrix.length;
        int c=matrix[0].length;
        if (r==0||c==0){
            return 0;
        }
        int[][] dp=new int[r][c];
        int size=0;
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                if (matrix[i][j]=='1'){
                    if (i==0||j==0){
                        dp[i][j]=1;
                    }else {
                        dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    }
                    size=Math.max(size,dp[i][j]);
                }
            }
        }
        return size*size;
    }
}
