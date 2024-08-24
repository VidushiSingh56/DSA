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
    public ListNode deleteMiddle(ListNode head) 
    { 
        if(head.next == null)
        return null;
    // int cut =1;
    // helper(head, cut);
    // ListNode temp=head;
    // return temp;
    // }
    // public int helper(ListNode temp, int cut)
    // {
    //     if(temp == null)
    //     {
    //         return 1;
    //     }
        
    //     int target = helper(temp.next, cut+1);
    //     if(target==cut+2 || target==cut+1)
    //     {
    //         temp.next = temp.next.next;
    //     }

    //     return ++target;

    ListNode first = head;
    ListNode second=head.next.next;
    while(second!=null && second.next!=null)
    {
        first=first.next;
        second=second.next.next;
    }
    first.next=first.next.next;
    return head;

    }

}