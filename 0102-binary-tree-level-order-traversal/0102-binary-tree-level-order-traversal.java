// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) 
//     {
//         // Queue<TreeNode> que = new LinkedList<TreeNode>();
//         // List<List<Integer>> ans =  new LinkedList<List<Integer>>();
//         // if(root == null) return ans;
//         // que.offer(root);
//         // while(!que.isEmpty())
//         // {
//         //     int size = que.size();
//         //     List<Integer> list = new LinkedList<Integer>();
//         //     for(int i =0;i<size;i++)
//         //     {
                
//         //         // TreeNode dummy = que.peek();
//         //         // que.pop();
//         //         if(que.peek().left != null) que.offer(que.peek().left);
//         //         if(que.peek().right != null) que.offer(que.peek().right);
//         //         list.add(que.poll().val);
//         //     }
//         //     ans.add(list);
//         // }
//         // return ans;
//     }
// }

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();  // Use LinkedList to implement the Queue
        List<List<Integer>> ans = new ArrayList<>();  // Result list to hold values for each level

        if (root == null) return ans;  // If root is null, return an empty list
        que.add(root);  // Add the root node to the queue

        while (!que.isEmpty()) {  // While there are nodes to process
            int size = que.size();  // Get the number of nodes at the current level
            List<Integer> list = new ArrayList<>();  // List to store values of the current level

            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();  // Remove the first node in the queue
                list.add(node.val);  // Add the node's value to the current level list

                if (node.left != null) que.add(node.left);  // Add the left child to the queue
                if (node.right != null) que.add(node.right);  // Add the right child to the queue
            }

            ans.add(list);  // Add the current level list to the result
        }

        return ans;  // Return the list of levels
    }
}
