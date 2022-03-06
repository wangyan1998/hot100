package algorithm;
//给定一个整数数组prices，其中第prices[i]表示第i天的股票价格 。
//        设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（
//        多次买卖一支股票）:
//        卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
//        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//        1 <= prices.length <= 5000
//        0 <= prices[i] <= 1000
/**
 * @author wy
 * @date 2022/3/6 17:52
 */
public class MaxProfit1 {
    public int maxProfit(int[] prices){
        if (prices.length==0){
            return 0;
        }
        int n=prices.length;
        //f[i][0]:手上持有股票的最大收益
        //f[i][1]:手上不持有股票，并且处于冷冻期中的累计最大收益
        //f[i][2]:手上不持有股票，并且不在冷冻期的累计最大收益
        int[][] f=new int[n][3];
        f[0][0]=-prices[0];
        for (int i=1;i<n;i++){
            f[i][0]=Math.max(f[i-1][0],f[i-1][2]-prices[i]);
            f[i][1]=f[i-1][0]+prices[i];
            f[i][2]=Math.max(f[i-1][1],f[i-1][2]);
        }
        return Math.max(f[n-1][1],f[n-1][2]);
    }
}
