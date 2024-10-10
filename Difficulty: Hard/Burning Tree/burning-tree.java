//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        Map<Node, Node> map = new HashMap<>();
        makeParents(map, root);
        Node n = findnode(root, target);
        Queue<Node> que = new LinkedList<>();
        Map<Node, Boolean> vis = new HashMap<>();
        que.offer(n);
        vis.put(n, true);
        int time=0;
        while(!que.isEmpty())
        {
            int size = que.size();
            boolean burned = false;
            for(int i =0;i<size;i++)
            {
                Node nod = que.poll();
                if(nod.left != null && !vis.containsKey(nod.left))
                {
                    que.offer(nod.left);
                    vis.put(nod.left, true);
                    burned = true;
                }
                if(nod.right != null && !vis.containsKey(nod.right))
                {
                    que.offer(nod.right);
                    vis.put(nod.right, true);
                    burned = true;
                }
                if(map.containsKey(nod) && !vis.containsKey(map.get(nod)))
                {
                    que.offer(map.get(nod));
                    vis.put(map.get(nod), true);
                    burned = true;
                }
            }
            if(burned) 
            time++;
        }
    return time;
    }
    public static void makeParents(Map<Node, Node> map, Node node) {
        Queue<Node> que = new LinkedList<>();
        que.offer(node);

        while (!que.isEmpty()) {
            Node currNode = que.poll();
            if (currNode.left != null) {
                que.offer(currNode.left);
                map.put(currNode.left, currNode);
            }
            if (currNode.right != null) {
                que.offer(currNode.right);
                map.put(currNode.right, currNode);
            }
        }
    }
    
    public static Node findnode(Node root, int target) {
    if (root == null) 
        return null;

    if (root.data == target) 
        return root;

    Node l = findnode(root.left, target);
    if (l != null) 
        return l;

    return findnode(root.right, target);
}
}