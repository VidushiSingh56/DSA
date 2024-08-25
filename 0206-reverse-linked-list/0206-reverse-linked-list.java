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
    public ListNode reverseList(ListNode head) 
    {
        //Iterative solution
        // if(head == null)
        // return null;
        // if(head.next == null)
        // return head;
        // ListNode temp=head;
        // ListNode prev=null;
        // ListNode front = head.next;
        // while(front != null)
        // {
        //     temp.next = prev;
        //     prev = temp;
        //     temp = front;
        //     front = front.next;
        // }
        // temp.next = prev;
        // return temp;

        //Recursive Solution
        if(head == null || head.next==null)
        return head;

       ListNode node = reverseLL(head);
        return node;
        
    }
    public ListNode reverseLL(ListNode temp)
    {
        if(temp == null || temp.next==null)return temp;

        ListNode Hn= reverseLL(temp.next);
        ListNode front = temp.next;
        front.next=temp;
        temp.next=null;
        return Hn;
    }
}