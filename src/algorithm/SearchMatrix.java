package algorithm;

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
