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
    public ListNode modifiedList(int[] nums, ListNode head) 
    {
        ListNode dummy = new ListNode(-1);  // Dummy node to handle edge cases
        dummy.next = head;
        ListNode prev = dummy, temp = head;
        Set<Integer> list = new HashSet<>();
        for(int i =0;i<nums.length;i++)
        {
            list.add(nums[i]);
        }
        while(temp != null)
        {
            if(list.contains(temp.val))
            {
                prev.next = temp.next;
                temp = prev.next;
            }
            else{
                prev=temp;
                temp=temp.next;
            }

        }
        return dummy.next;
    }
}