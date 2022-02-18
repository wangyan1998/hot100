package algorithm;
//给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。


/**
 * @author wy
 * @date 2022/2/18 15:23
 */
public class Rotate {
    /**
     * 先转置，再每行对称互换
     * @param matrix
     */
    public void rotate(int[][] matrix){
        int temp=0;
        for (int i=0;i<matrix.length;i++){
            for (int j=i+1;j<matrix.length;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix.length/2;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1]=temp;
            }
        }
    }
}
