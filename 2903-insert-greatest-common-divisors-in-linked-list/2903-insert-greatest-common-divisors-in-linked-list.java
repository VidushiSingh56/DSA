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
    public ListNode insertGreatestCommonDivisors(ListNode head) 
    {
        if(head==null || head.next==null)
        return head;

        ListNode temp = head.next;
        ListNode prev = head;
        while(temp!=null)
        {
            int value = findDivisor(temp.val, prev.val);
            ListNode newNode = new ListNode(value);
            prev.next = newNode;
            newNode.next = temp;
            prev= temp;
            temp=temp.next;
        }
        return head;
    }
    public int findDivisor(int a , int b)
    {
        if (b == 0) 
        return a;

        return findDivisor(b, a % b);
    }
}