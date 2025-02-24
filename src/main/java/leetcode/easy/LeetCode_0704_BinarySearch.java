package leetcode.easy;

/**
 * Given an array of integers nums which is sorted in ascending order, and an
 * integer target, write a function to search target in nums. If target exists,
 * then return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 9 Output: 4 Explanation: 9 exists in
 * nums and its index is 4 Example 2:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 2 Output: -1 Explanation: 2 does not
 * exist in nums so return -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^4
 * <p>
 * -10^4 < nums[i], target < 10^4
 * <p>
 * All the integers in nums are unique. nums is sorted in ascending order.
 *
 * @author Grey
 * @date 2021年7月16日 下午9:04:48
 * @since 1.8
 */
// https://leetcode.com/problems/binary-search/
public class LeetCode_0704_BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
