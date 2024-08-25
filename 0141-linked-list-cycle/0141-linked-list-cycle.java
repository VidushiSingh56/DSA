/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) 
    {
        int value= Integer.MAX_VALUE;
        int flag=0;
        ListNode temp=head;
        if(head == null)
        return false;

        while(temp != null && temp.next!=null)
        {
            temp.val = value;
            if(temp.val == temp.next.val)
            return true;
            temp=temp.next;
        }
        return false;
    }
}