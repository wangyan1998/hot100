package algorithm;
//给你一个二叉树的根节点 root ， 检查它是否轴对称。
import tool.TreeNode;

/**
 * @author wy
 * @date 2022/2/22 18:12
 */
public class IsSymmetric {
    /**
     * 双指针模拟对称结构
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
       return check(root,root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return q.val == p.val & check(p.left, q.right) & check(p.right, q.left);
    }
}
