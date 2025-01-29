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
class Solution 
{
    // int max = Integer.MAX_VALUE;
    // int min = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) 
    {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode root, long min, long max)
    {
        if(root == null)
        return true;

        if(root.val >= max || root.val <= min)
        {
             return false;
        }
        boolean ans = isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
        return ans;
    }
}