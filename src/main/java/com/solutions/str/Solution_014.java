package main.java.com.solutions.str;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_014 {
    public static void main(String[] args) {
        Solution_014 solution = new Solution_014();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int index = 0;
        String result = "";
        OUTER:
        while (true) {
            if (strs[0].length() < index + 1) {
                break OUTER;
            }
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i + 1].length() < index + 1) {
                    break OUTER;
                }
                if (strs[i].charAt(index) != strs[i + 1].charAt(index)) {
                    break OUTER;
                }
            }
            result = result + strs[0].charAt(index++);
        }
        return result;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(result) != 0) {
                if (result.isEmpty()) {
                    return "";
                }
                result = result.substring(0, result.length() - 1);
            }
        }
        return result;
    }
}
