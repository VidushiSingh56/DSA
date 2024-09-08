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
    public ListNode[] splitListToParts(ListNode head, int k) 
    {
        ListNode ans[]=new ListNode[k];
        if(head==null)
        {
            return ans;
        }
        int count=0;
        ListNode temp = head;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        
        ListNode dumm = head;
        ListNode next = head.next;
        int stsize = count/k;
        int i=0;
        temp = head;
        int c = 0;
        
        if(count<k)
        {
            while(temp != null)
            {
                temp.next=null;
                ans[i]=temp;
                i++;
                temp=next;
                next = (next!=null)?next.next:null;
            }
            while(i<k)
            {
                ans[i]=null;
                i++;
            }
        }
        else if(count%k==0)
        {
            //divide with count/k equally
            
            while(temp != null)
            {
                c++;
                if(c==stsize)
                {
                    temp.next = null;
                    ans[i]=dumm;
                    dumm = next;
                    c=0;
                    i++;
                }
                temp = next;
                next = (next!=null)?next.next:null;
            }

        }
        else
        {
            //groups = k

            //no of entity in first count%k group = count/k + 1
            //no of entity in k-count%k groups = count/k
            int mod = count%k;
            while(temp!=null)
            {
                c++;
                if(c == stsize && mod!=0 )
                {
                    --mod;
                    temp = next;
                    next = next.next;
                    temp.next=null;
                    ans[i]=dumm;
                    dumm = next;
                    c=0;
                    i++;
                }
                if(c==stsize && mod == 0)
                {
                    temp.next = null;
                    ans[i]=dumm;
                    dumm = next;
                    c=0;
                    i++;
                }
                
                temp = next;
                next = (next!=null)?next.next:null;
            }
        }
        return ans;
    }
}