/*
 The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.

Note: Each term of the sequence of integers will be represented as a string.



Example 1:

Input: 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: 4
Output: "1211"
Explanation: For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12" which means frequency = 1 and value = 2, the same way "1" is read as "11", so the answer is the concatenation of "12" and "11" which is "1211".
*/

package leetcode.medium;

// 测评链接：https://leetcode.com/problems/count-and-say/
@Deprecated
public class LeetCode_0038_CountAndSay {

	public static String countAndSay(int n) {
		if (n < 1) {
			return "";
		}
		if (n == 1) {
			return "1";
		}
		if (n == 2) {
			return "11";
		}
		String pre = countAndSay(n - 1);
		char[] p = pre.toCharArray();
		StringBuilder sb = new StringBuilder();
		int num = 1;
		for (int i = 1; i < p.length; i++) {
			if (p[i] == p[i - 1]) {
				num++;
			} else {
				sb.append(num).append(p[i - 1]);
				num = 1;
			}
		}
		sb.append(num).append(p[p.length-1]);
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(5));

	}
}
