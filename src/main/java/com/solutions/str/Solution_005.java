package main.java.com.solutions.str;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_005 {

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        // dp[i][j] = (dp[i+1][j-1] && si==sj )
        boolean[][] dp = new boolean[s.length()][s.length()];
        int strStart = 0;
        int strEnd = 0;
        int max = 1;
        dp[0][0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (dp[i - 1][j + 1] || i - j <= 2)) {
                    dp[i][j] = true;
                    if (i - j + 1 > max) {
                        strStart = j;
                        strEnd = i;
                        max = i - j + 1;
                    }
                }
            }
        }
        return s.substring(strStart, strEnd + 1);
    }

}
