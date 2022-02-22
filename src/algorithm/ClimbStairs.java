package algorithm;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
/**
 * @author wy
 * @date 2022/2/19 22:04
 */
public class ClimbStairs {
    public int climbStairs(int n){
        if(n==1||n==2){
            return n;
        }
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
