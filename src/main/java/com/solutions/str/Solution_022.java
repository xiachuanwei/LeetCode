package main.java.com.solutions.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_022 {
    public static void main(String[] args) {
        Solution_022 solution = new Solution_022();
        System.out.println(solution.generateParenthesis(2));
        System.out.println(solution.generateParenthesis(3));
    }


    public List<String> generateParenthesis(int n) {
        //dfs
        List<String> result = new ArrayList<>();
        dfs(result, "", 0, 0, n);
        return result;
    }

    private void dfs(List<String> result, String currStr, int left, int right, int max) {
        if (currStr.length() == max * 2) {
            result.add(currStr);
            return;
        }
        // 两种方式 1.左括号小于Max时 继续加左括号 2.右<左，时加右括号
        if (left < max) {
            dfs(result, currStr + "(", left + 1, right, max);
        }

        // 若右括号小于左括号，则可以加右括号
        if (right < left) {
            dfs(result, currStr + ")", left, right + 1, max);
        }
    }
}
