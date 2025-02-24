package leetcode;

import java.util.LinkedList;

/*Given a string s representing an expression, implement a basic calculator to evaluate it.



		Example 1:

		Input: s = "1 + 1"
		Output: 2
		Example 2:

		Input: s = " 2-1 + 2 "
		Output: 3
		Example 3:

		Input: s = "(1+(4+5+2)-3)+(6+8)"
		Output: 23


		Constraints:

		1 <= s.length <= 3 * 105
		s consists of digits, '+', '-', '(', ')', and ' '.
		s represents a valid expression.*/
public class LeetCode_0224_BasicCalculator {

    public static int calculate(String s) {
        return f(s.toCharArray(), 0)[0];
    }

    private static int[] f(char[] str, int i) {
        LinkedList<String> queue = new LinkedList<>();
        int c = 0;
        int[] b;
        while (i < str.length && str[i] != ')') {
            if (str[i] == ' ') {
                i++;
            } else if (str[i] >= '0' && str[i] <= '9') {
                c = c * 10 + str[i++] - '0';
            } else if (str[i] == '(') {
                b = f(str, i + 1);
                c = b[0];
                i = b[1] + 1;
            } else {
                // str[i]是运算符
                addNum(queue, c);
                queue.addLast(String.valueOf(str[i++]));
                c = 0;
            }
        }
        addNum(queue, c);

        return new int[]{getNum(queue), i};
    }

    private static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!que.isEmpty()) {
            cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.parseInt(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }

    private static void addNum(LinkedList<String> queue, int c) {
        if (!queue.isEmpty()) {
            int t = 0;
            String top = queue.pollLast();
            if ("*".equals(top)) {
                t = Integer.parseInt(queue.pollLast());
                c = c * t;
            } else if ("/".equals(top)) {
                t = Integer.parseInt(queue.pollLast());
                c = t / c;
            } else {
                queue.addLast(top);
            }
        }
        queue.addLast(String.valueOf(c));
    }

}
