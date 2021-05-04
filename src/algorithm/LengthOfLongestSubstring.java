package algorithm;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

import java.util.HashSet;
import java.util.Set;

/**
 * @author wy
 * @version 1.0
 * @date 2021/5/4 21:52
 */
public class LengthOfLongestSubstring {
    /**
     * 自写代码：设置一个set用来判断是否存在当前遍历到的字符，如果遇到重复的就求一次长度，并和记录的最长作比较。
     * 然后移除左指针指向的字符，直到不存在当前字符，加入当前字符。此题可以是双指针，也可以是滑动窗口（窗口大小在变）。
     * @param s
     * @return
     */
    public  int lengthOfLongestSubstring(String s){
        Set<Character> set=new HashSet<Character>();
        int left=0,right=0;
        int n=s.length();
        int max=0;
        for(;right<n;right++){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
            }else {
                max=Math.max(max,right-left);
                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
            }
        }
        max=Math.max(max,right-left);
        return max;
    }

    /**
     * 题解思想：以每一个字符为左边界，不断向右寻找不重复字符的右边界。
     * 和自写代码的区别是：自写代码是每次遇到重复的右边界就找一次不会重复的左边界，继续遍历
     * @param s
     * @return
     */
    public int lengthOfLongestSubString1(String s){
        //哈希集合，记录每一个字符是否出现过
       Set<Character> occ=new HashSet<Character>();
       int n=s.length();
       //右指针，初始值为-1，相当于我们在字符串左边界的左侧，还没有开始移动
        int rk=-1,ans=0;
        for(int i=0;i<n;i++){
            if(i!=0){
                //左指针向右移动一格
                occ.remove(s.charAt(i-1));
            }
            while(rk+1<n&&!occ.contains(s.charAt(rk+1))){
                //不断地移动右指针
                occ.add(s.charAt(rk+1));
                ++rk;
            }
            //第i到rk个字符是一个极长的无重复的字符子串
            ans=Math.max(ans,rk-i+1);
        }
        return ans;
    }


}
