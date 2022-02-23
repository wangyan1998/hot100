package algorithm;
//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
//        同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
//        路径和 是路径中各节点值的总和。
//        给你一个二叉树的根节点 root ，返回其 最大路径和 。


import tool.TreeNode;

/**
 * @author wy
 * @date 2022/2/23 16:58
 */
public class MaxPathSum {
    public int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
       dfs(root);
       return maxPath;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //只有当最大贡献值大于0时才会选择该节点，否则该节点就是负贡献
        int l = Math.max(dfs(root.left),0);
        int r = Math.max(dfs(root.right),0);
        maxPath = Math.max(maxPath, root.val + l + r);
        return root.val + Math.max(l, r);
    }
}
