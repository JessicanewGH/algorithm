//Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
//
//
//
//        Example 1:
//
//        Input: nums = [1,1,2]
//        Output:
//        [[1,1,2],
//        [1,2,1],
//        [2,1,1]]
//        Example 2:
//
//        Input: nums = [1,2,3]
//        Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//        Constraints:
//
//        1 <= nums.length <= 8
//        -10 <= nums[i] <= 10
package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/permutations-ii/
public class LeetCode_0047_PermutationsII {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        process(0, nums, ans);
        return ans;
    }

    private static void process(int i, int[] nums, List<List<Integer>> ans) {
        if (i == nums.length - 1) {
            List<Integer> path = new ArrayList<>();
            for (int n : nums) {
                path.add(n);
            }
            ans.add(path);
        } else {
            boolean[] visited = new boolean[21];
            for (int index = i; index < nums.length; index++) {
                if (!visited[nums[index] + 10]) {
                    visited[nums[index] + 10] = true;
                    swap(index, i, nums);
                    process(i + 1, nums, ans);
                    swap(index, i, nums);
                }
            }
        }
    }

    private static void swap(int index, int i, int[] nums) {
        if (index == i) {
            return;
        }
        nums[i] = nums[i] ^ nums[index];
        nums[index] = nums[i] ^ nums[index];
        nums[i] = nums[i] ^ nums[index];
    }
}
