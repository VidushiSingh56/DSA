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
    public boolean isPalindrome(ListNode head) 
    {
        if(head.next == null)
        return true;
        ListNode slow= head, fast = head;
        while( fast.next != null && fast.next.next!= null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second=reverse(slow.next);
        ListNode first = head;
        while(second != null)
        {
            if(second.val != first.val)
            return false;
            second=second.next;
            first=first.next;
        }
        return true;

    }
    public ListNode reverse(ListNode head)
    {
        ListNode temp=head;
        ListNode prev=null;
        ListNode front=temp.next;
        while(front!=null)
        {
            temp.next=prev;
            prev=temp;
            temp=front;
            front=front.next;
        }
        temp.next=prev;
        return temp;
    }
}