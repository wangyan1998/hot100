package algorithm;
//给定两个整数数组preorder 和 inorder，其中preorder
//        是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
//        1 <= preorder.length <= 3000
//        inorder.length == preorder.length
//        -3000 <= preorder[i], inorder[i] <= 3000
//        preorder和inorder均 无重复 元素
//        inorder均出现在preorder
//        preorder保证 为二叉树的前序遍历序列
//        inorder保证 为二叉树的中序遍历序列


import tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2022/2/23 14:16
 */
public class BuildTree {
    private Map<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder,int[] inorder){
        int n=preorder.length;
        indexMap=new HashMap<>();
        for(int i=0;i<n;i++){
            indexMap.put(inorder[i],i);
        }
        return build(preorder,inorder,0,n-1,0,n-1);
    }
    public TreeNode build(int[] preorder,int[] inorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right){
        if (preorder_left>preorder_right){
            return null;
        }
        //前序遍历的第一个节点就是根节点
        int preorder_root=preorder_left;
        //在中序遍历中定位根节点
        int inorder_root=indexMap.get(preorder[preorder_root]);
        //先把根节点建立出来
        TreeNode root=new TreeNode(preorder[preorder_root]);
        //得到左子树中节点数目
        int size_left_subtree=inorder_root-inorder_left;
        //递归构造左子树
        root.left=build(preorder,inorder,preorder_left+1,preorder_left+size_left_subtree,inorder_left,inorder_root-1);
        //递归构造右子树
        root.right=build(preorder,inorder,preorder_left+size_left_subtree+1,preorder_right,inorder_root+1,inorder_right);
        return root;
    }
}
