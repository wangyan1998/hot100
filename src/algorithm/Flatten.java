package algorithm;
//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//        展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，
//        而左子指针始终为 null 。
//        展开后的单链表应该与二叉树 先序遍历 顺序相同。


import tool.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author wy
 * @date 2022/2/23 15:36
 */
public class Flatten {
    /**
     * 先迭代遍历，然后一次生成
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode lat = list.get(i);
            pre.left = null;
            pre.right = lat;
        }
    }

    /**
     * 原地变化，分为两步
     * （1）寻找当前结点右子节点的前驱节点，也就是当前结点左子树的最右侧节点，然后让最右侧节点的
     * 右子树改为当前节点的右子树。
     * （2）将当前节点的左子树放到右子树上，将左节点置空
     * @param root
     */
    public void flatten1(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode left = cur.left, nxt = cur.left;
                while(nxt.right!=null){
                    nxt=nxt.right;
                }
                nxt.right=cur.right;
                cur.left=null;
                cur.right=left;
            }
            cur=cur.right;
        }
    }
}
