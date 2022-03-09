package algorithm;
//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
//        除了root之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
//        聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果
//        两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
//        给定二叉树的root。返回在不触动警报的情况下，小偷能够盗取的最高金额。


import tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2022/3/7 20:00
 */
public class Rob1 {
    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<>();

    /**
     * 动态规划：每个节点有两个状态：选中和不选中
     * 可以用f(o)表示选择o节点的情况下，o节点的子树上被选择的节点的最大权值和；
     * 可以用g(o)表示不选择o节点的情况下，o节点的子树上被选择节点的最大权值和；
     * l,r表示o的左右子树
     * 所以情况分为以下两种：
     * (1)当o被选中时，o的左右孩子都不能被选中，故o被选中情况下子树上被选中的最大权值和为l和r不被
     * 选中的最大权值和相加，即f(o)=g(l)+g(r)
     * (2)当o不被选中时，o的左右孩子可以被选中也可以不被选中，对于o的某一个具体的孩子x,它对o的贡献是
     * x被选中和不被选中情况下权值和的较大值。故g(o)=max{f(l),g(l)}+max{f(r),g(r)}
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }
}
