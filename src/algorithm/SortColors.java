package algorithm;
//给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，
//        并按照红色、白色、蓝色顺序排列。
//        我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
//        必须在不使用库的sort函数的情况下解决这个问题。
//       n == nums.length
//        1 <= n <= 300
//        nums[i] 为 0、1 或 2

/**
 * @author wy
 * @date 2022/2/20 16:41
 */
public class SortColors {
    /**
     * 先统计再赋值，两次遍历
     * @param nums
     */
    public void sortColors(int[] nums) {
        int a = 0, b = 0, c = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                a++;
            } else if (nums[i] == 1) {
                b++;
            } else {
                c++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i < a) {
                nums[i] = 0;
            } else {
                if (i < a + b) {
                    nums[i] = 1;
                } else {
                    nums[i] = 2;
                }
            }
        }
    }

    /**
     * 把0放在前面，2放在后面，对于交换的2，如果换出来的不是1，则i--，再经历一次交换
     * @param nums
     */
    public void sortColors1(int[] nums){
        int n=nums.length;
        if(n<2){
            return;
        }
        int p=0,q=n-1,i=0;
        while(i<=q){
            if(nums[i]==0){
                nums[i]=nums[p];
                nums[p]=0;
                p++;
            }
            if(nums[i]==2){
                nums[i]=nums[q];
                nums[q]=2;
                q--;
                if(nums[i]!=1){
                    i--;
                }
            }
            i++;
        }
    }
}
