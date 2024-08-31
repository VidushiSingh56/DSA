/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) 
    {
        Node temp = head;
        while(temp!=null)
        {
            
            Node nn = new Node(temp.val);
            nn.next = temp.next;
            temp.next = nn;
            temp=temp.next.next;
        }
        temp = head;
        while(temp != null)
        {
            temp.next.random =(temp.random==null) ? temp.random: temp.random.next;
            temp=temp.next.next;
        }
        Node dummy = new Node(-1);
        Node res = dummy;
        temp = head;
        while(temp != null)
        {
            res.next = temp.next;
            temp.next = res.next.next;
            res = res.next;
            temp=temp.next;
        }
        return dummy.next;
        
    }
}