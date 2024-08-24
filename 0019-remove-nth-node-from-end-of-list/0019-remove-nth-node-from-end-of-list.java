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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode dummy = new ListNode(0, head);
        helper(dummy, head, n);
        return dummy.next;
    }
    public int helper(ListNode prev, ListNode temp, int n)
    {
       
        if (temp == null) {
            return 1; // Start counting from the end of the list
        }

        int cut = helper(temp, temp.next, n); // Recurse to the end of the list
        if (cut == n) {
            prev.next = temp.next; // Remove the nth node
        }
        return ++cut; // Increment the count
    
        

    }
}