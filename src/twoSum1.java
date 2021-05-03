//给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
//        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//        你可以按任意顺序返回答案。


/**
 * @author wy
 * @version 1.0
 * @date 2021/5/3 12:27
 */
public class twoSum1 {
    /**
     * 自写
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums,int target){
        int n=nums.length;
        int i=0,j=0;
        boolean flag=true;
        for( i=0;i<n;i++){
           int a=target-nums[i];
           for(j=i+1;j<n;j++){
               if(nums[j]==a){
                   flag=false;
                   break;
               }
           }
           if(flag==false){
               break;
           }
        }
        return new int[]{i,j};
    }
    /*下面是官方题解*/

    /**
     * 暴力解法，简洁明了，做题一定要考虑边界，也就是着重关注特殊情况。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums,int target){
        if(nums==null||nums.length==0){
            return new int[0];
        }
        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==target-nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

}
