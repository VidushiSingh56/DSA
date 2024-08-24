//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) 
    {
        Node one = new Node(1);
        if(head == null)
        {
            return one;
        }
        Node head1=reverseLL(head);
        int carry =1;
        Node temp=head1, prev=null;
        int sum=0;
        while(temp!=null)
        {
            sum = temp.data+carry;
            temp.data = sum%10;
            carry = sum/10;
            prev=temp;
            temp=temp.next;
        }
        if(carry != 0)
        {
            Node nn = new Node(carry);
            prev.next = nn;
        }
        return reverseLL(head1);
        // code here.
    }
    public Node reverseLL(Node head)
    {
        Node temp=head;
        Node prev=null;
        Node next=temp.next;
        while(temp.next!=null)
        {
            temp.next = prev;
            prev=temp;
            temp=next;
            next=temp.next;
        }
        temp.next=prev;
        return temp;
    }
}
