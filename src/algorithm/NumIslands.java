package algorithm;
//给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//        岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//        此外，你可以假设该网格的四条边均被水包围。
//        m == grid.length
//        n == grid[i].length
//        1 <= m, n <= 300
//        grid[i][j] 的值为 '0' 或 '1'

/**
 * @author wy
 * @date 2022/3/1 21:34
 */
public class NumIslands {
    public int numIslands(char[][] grid){
       int r=grid.length;
       if (r==0){
           return 0;
       }
       int c=grid[0].length;
       int res=0;
       for (int i=0;i<r;i++){
           for (int j=0;j<c;j++){
               if (grid[i][j]=='1'){
                   res++;
                   dfs(grid,r,c,i,j);
               }
           }
       }
       return res;
    }
    public void dfs(char[][] grid,int r,int c,int i,int j){
        if (i>=0&&i<r&&j>=0&&j<c&&grid[i][j]=='1'){
            grid[i][j]='0';
        }else {
            return;
        }
        dfs(grid,r,c,i+1,j);
        dfs(grid,r,c,i-1,j);
        dfs(grid,r,c,i,j-1);
        dfs(grid,r,c,i,j+1);
    }
}
