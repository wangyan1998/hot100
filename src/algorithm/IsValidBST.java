package algorithm;
//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//        有效 二叉搜索树定义如下：
//        节点的左子树只包含 小于 当前节点的数。
//        节点的右子树只包含 大于 当前节点的数。
//        所有左子树和右子树自身必须也是二叉搜索树。

import tool.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wy
 * @date 2022/2/22 17:29
 */
public class IsValidBST {
    /**
     * 递归，以root为根节点的二叉搜索树，左子树上的值都小于根节点，右子树上的值都大于根节点
     * 其左右子树也都是二叉搜索树
     * 所以可以用范围进行判断
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST1(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST1(node.left, lower, node.val) && isValidBST1(node.right, node.val, upper);
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
