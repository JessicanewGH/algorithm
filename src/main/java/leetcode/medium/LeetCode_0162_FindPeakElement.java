package leetcode.medium;

//A peak element is an element that is greater than its neighbors.
//
//        Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
//
//        The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//
//        You may imagine that nums[-1] = nums[n] = -∞.
//
//        Example 1:
//
//        Input: nums = [1,2,3,1]
//        Output: 2
//        Explanation: 3 is a peak element and your function should return the index number 2.
//        Example 2:
//
//        Input: nums = [1,2,1,3,5,6,4]
//        Output: 1 or 5
//        Explanation: Your function can return either index number 1 where the peak element is 2,
//        or index number 5 where the peak element is 6.
//        Follow up: Your solution should be in logarithmic complexity.
// 返回局部高点
// 二分
// https://www.cnblogs.com/greyzeng/p/15000448.html
public class LeetCode_0162_FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        // 以上逻辑是校验两端
        // 到这里，说明两端都不是局部最大值
        int l = 1;
        int r = nums.length - 2;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] <= nums[mid - 1]) {
                r = mid - 1;
            } else if (nums[mid] <= nums[mid + 1]) {
                l = mid + 1;
            }
        }
        return -1;
    }

}
