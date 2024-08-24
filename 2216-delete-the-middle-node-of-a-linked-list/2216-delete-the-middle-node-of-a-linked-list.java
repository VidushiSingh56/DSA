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

        ListNode temp = head;
        int cut=0;
        while(temp != null)
        {
            cut+=1;
            temp=temp.next;
        }
        System.out.println(cut+ " ");
        int target = cut/2;
        cut=1;
        System.out.println(target+ " ");
        temp = head;
        while(temp!=null)
        {
            if(cut == target)
            {
                temp.next=temp.next.next;
                
                break;
            }
            cut++;
            temp=temp.next;

        }
        return head;
    }
}