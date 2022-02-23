package algorithm;
//给定一个二叉树，找出其最大深度。
//        二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//        说明: 叶子节点是指没有子节点的节点。
import tool.TreeNode;

/**
 * @author wy
 * @date 2022/2/22 22:22
 */
public class MaxDepth {
    public int maxDepth(TreeNode root){
        return dfs(root);
    }
    public int dfs(TreeNode root){
        if (root==null){
            return 0;
        }
        int l=0,r=0;
        if (root.left!=null){
            l=dfs(root.left);
        }
        if (root.right!=null){
            r=dfs(root.right);
        }
        return Math.max(l,r)+1;
    }

}
