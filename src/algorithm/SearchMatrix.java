package algorithm;
//编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//        每行的元素从左到右升序排列。
//        每列的元素从上到下升序排列。
//        m == matrix.length
//        n == matrix[i].length
//        1 <= n, m <= 300
//        -10^9<= matrix[i][j] <= 10^9
//        每行的所有元素从左到右升序排列
//        每列的所有元素从上到下升序排列
//        -10^9<= target <= 10^9

/**
 * @author wy
 * @date 2022/3/4 18:22
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix,int target){
        int m=matrix.length;
        int n=matrix[0].length;
        int i=0,j=n-1;
        while(i>=0&&i<m&&j>=0&&j<n){
            if (matrix[i][j]==target){
                return true;
            }
            else if(matrix[i][j]<target){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}
