package algorithm;
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
//        最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度
//        尽可能大（一个节点也可以是它自己的祖先）。”
//        树中节点数目在范围 [2, 10^5] 内。
//        -10^9 <= Node.val <= 10^9
//        所有 Node.val 互不相同 。
//        p != q
//        p 和 q 均存在于给定的二叉树中。


import tool.TreeNode;

import java.util.List;

/**
 * @author wy
 * @date 2022/3/4 16:04
 */
public class LowestCommonAncestor {
    /**
     * 情况一：p和q分布在了当前根的左子树和右子树上面，此时当前根就是二者的最近公共祖先，
     * 递归中可直接返回当前根结点。
     * 情况二：p和q分布在了当前根的某一边的子树上，当前根结点为p和q其中之一也归结为此情况。
     * 递归时，我们想象是递归查找p或者q，如果当前root是p或者q直接返回，如果当前root不是p
     * 或者q，那么就像左右递归，判空得到左右子树存在p和q的情况，都存在那么直接返回root。
     * 否则直接返回左右存在的那个返回值，因为p和q都存在同一棵子树上，那么第一个找到的点就
     * 是最后的答案。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || (root == p || root == q)) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) {
            return root;
        }
        return l != null ? l : r;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || (root == p || root == q)) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l!=null) return l;
        if (r!=null) return r;
        return root;
    }
}
