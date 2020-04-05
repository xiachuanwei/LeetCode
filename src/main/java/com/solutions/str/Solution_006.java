package main.java.com.solutions.str;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * LDREOEIIECIHNTSG
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_006 {

    public static void main(String[] args) {
        Solution_006 solution_006 = new Solution_006();
        System.out.println(solution_006.convert("LEETCODEISHIRING", 3));
        System.out.println(solution_006.convert("LEETCODEISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        // 一组长度为 width = 2n-1
        // 行0 中元素 i % width = 0; => width * j
        // 行k 中元素 i%width = k || (2n-2k-1) => width * j +1 或 width * j +2n-2k -1
        // 行n 中元素 i%width = n   => width * j + n
        if (s.length() <= numRows || numRows == 1) return s;
        char[] chars1 = s.toCharArray();
        char[] chars2 = new char[chars1.length];
        int index = 0; // 位置
        int width = 2 * numRows - 2; // 每组长度
        int flag = s.length() / width + 1; // 共分为几组
        int last = s.length() % width; // 最后一组长度

        for (int k = 0; k < numRows; k++) {
            for (int i = 0; i < flag; i++) {
                int first = i * width + k;
                if (index < s.length() && first < s.length()) {
                    chars2[index++] = s.charAt(first);
                    // 第一个和最后一个不能加
                    int next = i * width + width - k;
                    if (k != 0 && k != numRows - 1 && next < s.length()) {
                        chars2[index++] = s.charAt(next);
                    }
                }
            }
        }
        return new String(chars2);
    }
}
