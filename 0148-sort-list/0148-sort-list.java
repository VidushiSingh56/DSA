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
    
    public ListNode sortList(ListNode head) 
    {
        if(head == null || head.next == null)
        return head;
        ListNode middleNote = middle(head), firstHead = head, secondHead = middleNote.next;
        middleNote.next=null;
        ListNode h1 = sortList(firstHead);
        ListNode h2 = sortList(secondHead);
        ListNode newHead = merge(h1, h2);
        return newHead;
    }
    public ListNode middle(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next !=null)
        {
            slow=slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode head1, ListNode head2)
    {
        ListNode t1 = head1;
        ListNode t2 = head2;
        ListNode dummy=new ListNode(0);
        ListNode mover = dummy;
        while(t1 != null && t2 != null)
        {
            if(t1.val <= t2.val)
            {
                ListNode nn = new ListNode(t1.val);
                t1=t1.next;
                mover.next=nn;
                mover=mover.next;
            }
            else 
            {
                ListNode nn = new ListNode(t2.val);
                t2=t2.next;
                mover.next=nn;
                mover=mover.next;
            }

        }
        while(t1 != null)
        {
            ListNode nn = new ListNode(t1.val);
            t1=t1.next;
            mover.next=nn;
            mover=mover.next;
        }
        while(t2 != null)
        {
            ListNode nn = new ListNode(t2.val);
            t2=t2.next;
            mover.next=nn;
            mover=mover.next;
        }
        return dummy.next;

    }
}