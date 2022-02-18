package algorithm;
//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//        数组中的每个元素代表你在该位置可以跳跃的最大长度。
//        判断你是否能够到达最后一个下标。
/**
 * @author wy
 * @date 2022/2/18 22:03
 */
public class CanJump {
    /**
     * 贪心算法：每次都求可到达的最右侧位置，该位置左侧的位置都是可达的。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums){
        int n=nums.length;
        int right=0;
        for(int i=0;i<n;i++){
            if(i<=right){
                right=Math.max(right,i+nums[i]);
            }
            if(right>=n-1){
                return true;
            }
        }
        return false;
    }
}
