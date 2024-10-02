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
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List<Integer> list = new ArrayList<>();
        in(root, list);
        return list;
    }
    public void in(TreeNode node, List<Integer> list)
    {
        if(node == null)
        return;

        in(node.left, list);
        list.add(node.val);
        in(node.right, list);
    }
}