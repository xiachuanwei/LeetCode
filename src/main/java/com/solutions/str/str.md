##### 字符串常见题目
1.求最长无重复子串 

链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters

解题方法：滑动窗口（双指针）方法,记下最大值，左边为无重复的起点，右边往右移

```
public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 左边和历史记录选一个作为最左
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
```
2.求回文字符串

链接：https://leetcode-cn.com/problems/longest-palindromic-substring

解题方法：动态规划即可,dp(i,j) = dp(i+1)(j-1) && (si = sj || i-j < 3),即若(i,j)为回文，则(i+1，j-1)为回文或者i-j<3(靠着或者对称)

3.求Z字型输出，这个找规律即可

https://leetcode-cn.com/problems/zigzag-conversion

4.