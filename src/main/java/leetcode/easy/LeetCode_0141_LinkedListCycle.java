package leetcode.easy;

public class LeetCode_0141_LinkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;
    }

    public static boolean hasCycle(ListNode head) {
        if (null == head || head.next == null) {
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        if (fast == null) {
            return false;
        }
        if (fast.next == null) {
            return false;
        }
        while (fast != slow) {
            fast = fast.next.next;
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }


}
