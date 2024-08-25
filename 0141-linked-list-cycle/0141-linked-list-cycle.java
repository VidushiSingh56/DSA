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
        // int value= Integer.MAX_VALUE;
        // ListNode temp=head;
        // if(head == null)
        // return false;

        // while(temp != null && temp.next!=null)
        // {
        //     temp.val = value;
        //     if(temp.val == temp.next.val)
        //     return true;
        //     temp=temp.next;
        // }
        // return false;
        if(head == null)
        return false;

        ListNode slow=head;
        ListNode fast= head.next;
        while(slow != fast)
        {
            if(fast==null || fast.next == null)
            return false;

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
        


    }
}