package algorithm;

import tool.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个
//        文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
//        请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行
//        逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
//        提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树
//        的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。


/**
 * @author wy
 * @date 2022/3/6 16:03
 */
public class Codec {
    public String serialize(TreeNode root){
       return rserialize(root,"");
    }
    public TreeNode deserialize(String data){
        String[] dataArray=data.split(",");
        List<String> dataList=new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }
    public String rserialize(TreeNode root,String str){
        if (root==null){
            str+="None,";
        }else {
            str+=root.val+",";
            str=rserialize(root.left,str);
            str=rserialize(root.right,str);
        }
        return str;
    }
    public TreeNode rdeserialize(List<String> dataList){
        if (dataList.get(0).equals("None")){
            dataList.remove(0);
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left=rdeserialize(dataList);
        root.right=rdeserialize(dataList);
        return root;
    }
}
