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
        // ListNode prev=new ListNode(0, head);
        // int cut= helper(prev, head, n);
        // return prev.next;

        ListNode fast = head;
        ListNode slow= head;
        for(int i=0;i<n;i++)
        fast=fast.next;

        if(fast == null)
        return head.next;

        while(fast.next != null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;

    }
    // public int helper(ListNode prev, ListNode temp, int n)
    // {
    //     if(temp == null)
    //     return 1;

    //     int cut = helper(temp, temp.next, n);
    //     if(cut == n)
    //     {
    //         prev.next=temp.next;
    //         temp.next=null;
    //     }
    //     return ++cut;
    // }
}