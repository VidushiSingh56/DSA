/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) 
    {
        int lh = findLeft(root);
        int rh = findRight(root);

        if(lh == rh)
        return (int)Math.pow(2,lh) - 1;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    public int findLeft(TreeNode node)
    {
        int count = 0;
        while(node != null)
        {
            count++;
            node=node.left;
        }
        return count;
    }
    public int findRight(TreeNode node)
    {
        int count = 0;
        while(node != null)
        {
            count++;
            node=node.right;
        }
        return count;
    }
    
}