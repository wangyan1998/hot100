package algorithm;
//给你二叉树的根节点 root ，返回其节点值的层序遍历 。 （即逐层地，从左到右访问所有节点）。
import sun.reflect.generics.tree.Tree;
import tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wy
 * @date 2022/2/22 18:15
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root){
       List<List<Integer>> res=new ArrayList<>();
       if (root==null){
           return res;
       }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> cur=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                cur.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(cur);
        }
        return res;
    }
}
