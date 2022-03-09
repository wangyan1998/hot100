package algorithm;
//给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，
//        返回一个长度为 n + 1 的数组 ans 作为答案。
/**
 * @author wy
 * @date 2022/3/7 20:51
 */
public class CountBits {
    public int[] countBits(int n){
        int[] ones=new int[n+1];
        for (int i=0;i<n+1;i++){
            ones[i]=countOnes(i);
        }
        return ones;
    }
    public int countOnes(int x){
        int ones=0;
        while (x!=0){
            x&=(x-1);
            ones++;
        }
        return ones;
    }

    /**
     * 动态规划
     * @param num
     * @return
     */
    public int[] countBits1(int num){
        int[] res=new int[num+1];
        res[0]=0;
        for (int i=1;i<=num;i++){
            if (i%2==1){
                res[i]=res[i-1]+1;
            }else {
                res[i]=res[i/2];
            }
        }
        return res;
    }
}
