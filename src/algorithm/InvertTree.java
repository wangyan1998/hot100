package algorithm;
//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
import tool.TreeNode;

/**
 * @author wy
 * @date 2022/3/4 14:51
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root){
        if (root==null){
            return null;
        }
        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
}
