package algorithm;
//给定一个m x n 二维字符网格board 和一个字符串单词word 。
//        如果word 存在于网格中，返回 true ；否则，返回 false 。
//        单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中
//        “相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//        m == board.length
//        n = board[i].length
//        1 <= m, n <= 6
//        1 <= word.length <= 15
//        board 和 word 仅由大小写英文字母组成

/**
 * @author wy
 * @date 2022/2/22 11:09
 */
public class Exist {
    /**
     * 回溯法，判断是否存在从当前位置到字符最后的子串
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int h=board.length,w=board[0].length;
        boolean[][] visited=new boolean[h][w];
        for(int i=0;i<h;i++){
            for (int j=0;j<w;j++){
                boolean flag=check(board,visited,i,j,word,0);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result=false;
        for (int[] dir:directions){
            int newi=i+dir[0],newj=j+dir[1];
            if(newi>=0&&newi<board.length&&newj>=0&&newj<board[0].length){
                if (!visited[newi][newj]){
                    boolean flag=check(board,visited,newi,newj,s,k+1);
                    if(flag){
                        result=true;
                        break;
                    }
                }
            }
        }
        visited[i][j]=false;
        return result;
    }
}
