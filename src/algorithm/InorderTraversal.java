package algorithm;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;
//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
/**
 * @author wy
 * @date 2022/2/22 16:32
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res=new ArrayList<>();
       inorder(root,res);
       return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right,res);

    }
}
