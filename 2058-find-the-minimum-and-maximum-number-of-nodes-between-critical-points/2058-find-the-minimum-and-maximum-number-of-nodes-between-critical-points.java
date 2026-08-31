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
// class ListNode
// {
//     int val;
//     ListNode next;
//     ListNode()
//     {

//     }
//     ListNode(int val)
//     {
//         this.val = val;
//     }
//     ListNode(int val, ListNode next)
//     {
//         this.val = val; this.next = next;
//     }
// } 
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) 
    {
        List<Integer> list = new ArrayList<>();
        ListNode dummy = new ListNode(0, head);
        int counter = 1;
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode nextnode = cur.next;
        while(cur != null && nextnode != null)
        {
            if(prev.val != 0 && ((prev.val > cur.val && nextnode.val > cur.val) || (prev.val < cur.val && nextnode.val < cur.val)))
            {
                list.add(counter);
            }
            counter++;
            prev = cur;
            cur = cur.next;
            nextnode = nextnode.next;
        }

        if(list.isEmpty() || list.size() == 1)
        return new int[]{-1,-1};
        int max, min = Integer.MAX_VALUE;
        int n = list.size();
        for(int i = 0; i<n-1;i++)
        {
            min = (int)Math.min(min, list.get(i+1) - list.get(i));
        }

        max = list.get(n-1) - list.get(0);
        return new int[]{min,max};
    }
}