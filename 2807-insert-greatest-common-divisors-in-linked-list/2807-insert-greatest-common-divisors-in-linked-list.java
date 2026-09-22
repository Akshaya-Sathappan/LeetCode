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
        ListNode node = head;
        ListNode result = head;

        while(node.next != null){
            int a = node.val;
            int b = node.next.val;
            int out = gcd(a , b);

            ListNode temp = node.next;
            ListNode c = new ListNode(out, temp);
            node.next = c;

            node = node.next.next;
        }

        return result;
    }

    int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}