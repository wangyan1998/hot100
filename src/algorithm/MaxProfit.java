package algorithm;
//给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
//        你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
//        设计一个算法来计算你所能获取的最大利润。
//        返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
//        1 <= prices.length <= 10^5
//        0 <= prices[i] <= 10^4

/**
 * @author wy
 * @date 2022/2/23 15:58
 */
public class MaxProfit {
    public int maxProfit(int[] prices){
        int min=prices[0];
        int n=prices.length;
        int res=0;
        for(int i=0;i<n;i++){
            min=Math.min(prices[i],min);
            res=Math.max(res,prices[i]-min);
        }
        return res;
    }
}
