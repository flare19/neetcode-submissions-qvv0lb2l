/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode left = head;
        ListNode right = head.next;
        while(right != null) {
            ListNode temp = right;
            left.next = new ListNode(getGreatestCommonDivisor(left.val, right.val));
            left.next.next = temp;
            right = right.next;
            left = left.next.next;
        }
        return head;
    }

    public int getGreatestCommonDivisor(int a, int b) {
        while(b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
}