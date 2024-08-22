/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution 
{
    public void deleteNode(ListNode node) 
    {
        
        int x= node.next.val;
        // ListNode temp = new ListNode(null);
        // if(node.next == null)
        // {

        // }
        
        if(node.next.next != null)
        {
            ListNode y=node.next.next;
            node.val = x;
            node.next=y;
            
        }
        else
        {
            node.val=x;
            node.next=null;
        }
        
    }
}