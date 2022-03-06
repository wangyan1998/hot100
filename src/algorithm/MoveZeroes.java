package algorithm;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//        请注意 ，必须在不复制数组的情况下原地对数组进行操作。
/**
 * @author wy
 * @date 2022/3/5 11:48
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums){
        int l=0,r=0;
        int n=nums.length;
        for (;r<n;r++){
            if (nums[r]!=0){
                int temp=nums[r];
                nums[r]=nums[l];
                nums[l]=temp;
                l++;
            }
        }
    }
}
