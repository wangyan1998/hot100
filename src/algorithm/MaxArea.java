package algorithm;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
//        在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和
//        (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
//        说明：你不能倾斜容器。


/**
 * @author wy
 * @date 2022/2/11 10:53
 */
public class MaxArea {
    /**
     * 双指针法
     * @param height
     * @return
     */
    public int maxArea(int[] height){
        int l=0,r=height.length-1;
        int res=0;
        while(l<r){
            int area=Math.min(height[l],height[r])*(r-l);
            res=Math.max(res,area);
            if(height[l]<=height[r]){
                l++;
            }else {
                r--;
            }
        }
        return res;
    }
}
