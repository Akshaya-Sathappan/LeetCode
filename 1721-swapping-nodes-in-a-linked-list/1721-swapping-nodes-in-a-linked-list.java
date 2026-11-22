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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode currentNode = head;
        int listLength = 0;

        while(currentNode != null){
            listLength++;
            currentNode = currentNode.next;
        }

        ListNode frontNode = head;

        for(int i = 1; i < k; i++){
            frontNode = frontNode.next;
        }

        ListNode endNode = head;

        for(int i = 1; i <= listLength - k; i++){
            endNode = endNode.next;
        }

        int temp = frontNode.val;
        frontNode.val = endNode.val;
        endNode.val = temp;

        return head;
    }
}