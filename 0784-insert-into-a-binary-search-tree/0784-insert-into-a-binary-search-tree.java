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
    public TreeNode insertIntoBST(TreeNode root, int val) 
    {
        if(root == null)
        {
            TreeNode node = new TreeNode(val, null, null);
            return node;
        }
        TreeNode cur = root;
        while(true)
        {
            if(cur.val < val)
            {
                if(cur.right != null)cur=cur.right;
                else
                {
                    TreeNode node = new TreeNode(val, null, null);
                    cur.right = node;break;
                }
            }
            else
            {
                if(cur.left != null)cur=cur.left;
                else
                {
                    TreeNode node = new TreeNode(val, null, null);
                    cur.left = node;break;
                }
            }
        }
        return root;
    }
}