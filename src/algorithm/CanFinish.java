package algorithm;
//你这个学期必须选修numCourses门课程，记为0到numCourses - 1 。
//        在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites给出，
//        其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai则必须先学习课程bi 。
//        例如，先修课程对[0, 1]表示：想要学习课程0，你需要先完成课程 1 。
//        请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
//        1 <= numCourses <= 10^5
//        0 <= prerequisites.length <= 5000
//        prerequisites[i].length == 2
//        0 <= ai, bi < numCourses
//        prerequisites[i] 中的所有课程对 互不相同


import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2022/3/2 9:27
 */
public class CanFinish {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid=true;

    /**
     * 其实就是判断有向图中是否有环
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses,int[][] prerequisites){
        //邻接表存储图的边
        edges=new ArrayList<List<Integer>>();
        for (int i=0;i<numCourses;i++){
            edges.add(new ArrayList<Integer>());
        }
        visited=new int[numCourses];
        for (int[] info:prerequisites){
            edges.get(info[1]).add(info[0]);
        }
        //依次对于未访问的节点进行深度遍历
        for (int i=0;i<numCourses&&valid;i++){
            if (visited[i]==0){
                dfs(i);
            }
        }
        return valid;
    }
    public void dfs(int u){
        //设置节点状态为访问中
        visited[u]=1;
        //对于u的邻边
        for (int v:edges.get(u)){
            //如果该节点没有被访问过
            if (visited[v]==0){
                //继续深度遍历
                dfs(v);
                //如果已经发现圈，直接返回
                if (!valid){
                    return;
                }
            }else if(visited[v]==1){//如果该节点正在访问中，说明搜索到了环，也就是又返回了深度遍历的某个起点
                valid=false;
                return;
            }
        }
        //设置节点状态为已访问
        visited[u]=2;
    }
}
