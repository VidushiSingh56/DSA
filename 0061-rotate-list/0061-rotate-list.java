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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head==null)
        return head;
        if(head.next == null)
        return head;

        ListNode temp = head;
        int count =0;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        
        k = k%count;
        
        if(k == 0)
        return head;

        ListNode prev=null;
        temp = head;
        int cut = 0;
        System.out.println(count -k);
        ListNode nn=null;
        while(temp.next != null)
        {
           
            if(cut < count-k)
            {
                cut++;
                prev = temp;
                nn=prev.next;
            }
            temp=temp.next;
        }
        
        prev.next = null;
        temp.next =head;
        return nn;
    }
}