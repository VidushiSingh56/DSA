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
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<inorder.length;i++)
        {
            map.put(inorder[i], i);
        }
        int n = inorder.length-1;
        return build(inorder, postorder, 0, n, 0, n, map);
    }
    public TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart,
    int postEnd, Map<Integer, Integer> map)
    {
        if(inStart>inEnd || postStart>postEnd)
        {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(root.val);
        int  numLeft = inRoot-inStart;

        root.left = build(inorder, postorder, inStart, inRoot-1, postStart, postStart+numLeft-1,map);
        root.right = build(inorder, postorder, inRoot+1, inEnd, postStart+numLeft, postEnd-1, map);

        return root;
    }
}