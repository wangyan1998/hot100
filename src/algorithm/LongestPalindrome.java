package algorithm;

/**
 * @author wy
 * @date 2022/2/8 11:39
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int l = s.length();
        if(l<2){
            return s;
        }
        boolean[][] dp = new boolean[l][l];
        for (int i = 0; i < l; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int len = 0;
        for (int i = 2; i <= l; i++) {
            for (int j = 0; j < l; j++) {
                int k = j + i - 1;
                if (k >= l) {
                    break;
                }
                if (s.charAt(j) != s.charAt(k)) {
                    dp[j][k] = false;
                } else {
                    if (k - j >= 3) {
                        dp[j][k] = dp[j + 1][k - 1];
                    } else {
                        dp[j][k] = true;
                    }
                }
                if (k - j + 1 > len && dp[j][k]) {
                    len = j - k + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + len);
    }
}
