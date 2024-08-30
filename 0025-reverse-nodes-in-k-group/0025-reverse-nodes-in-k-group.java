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
    public ListNode reverseKGroup(ListNode head, int k) 
    {
       ListNode temp = head;
        ListNode newHead = null;
        ListNode prev=null;
       while(temp != null)
       {
            ListNode kth = findkthNode(temp, k);
            if(kth == null)
            {
                prev.next = temp;
                break;
            }
            ListNode front = kth.next;
            kth.next=null;
            ListNode nn = reverse(temp);
            System.out.print(nn.val + " ");
            if(temp == head)
            {
                newHead = nn;
            }
            else {
                prev.next = nn;
            }
            prev = temp;
            temp = front;
       }
       return newHead;
    }
    public ListNode findkthNode(ListNode head, int k)
    {
        ListNode temp = head;
        int count =1;
        while(count < k)
        {
            if(temp == null)
            return null;

            count++;
            temp= temp.next;
            
        }
        return temp;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode temp = head;
        ListNode next = head.next;
        while(next != null)
        {
            temp.next = prev;
            prev = temp;
            temp = next;
            next = next.next;
        }
        temp.next = prev;
        return temp;
    }
    
}