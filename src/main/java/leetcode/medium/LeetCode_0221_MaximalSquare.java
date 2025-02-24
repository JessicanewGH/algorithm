/*Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

        Example:

        Input:

        1 0 1 0 0
        1 0 1 1 1
        1 1 1 1 1
        1 0 0 1 0

        Output: 4*/
package leetcode.medium;

// tips 正方形必须以i,j作为右下角情况，哪个正方形内部都是1且最大
// 依赖 左边一个位置，上面一个位置，左上角位置
public class LeetCode_0221_MaximalSquare {

    public static int maximalSquare(char[][] m) {
        if (null == m || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        int M = m.length;
        int N = m[0].length;
        int max = 0;
        // tips 正方形必须以i,j作为右下角情况，哪个正方形内部都是1且最大
        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            dp[i][0] = m[i][0] == '1' ? 1 : 0;
            max = Math.max(dp[i][0], max);
        }
        for (int i = 0; i < N; i++) {
            dp[0][i] = m[0][i] == '1' ? 1 : 0;
            max = Math.max(dp[0][i], max);
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = m[i][j] == '1' ? Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1 : 0;
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }


}
