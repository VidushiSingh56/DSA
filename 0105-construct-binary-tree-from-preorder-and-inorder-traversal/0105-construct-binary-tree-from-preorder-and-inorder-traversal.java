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
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i], i);
        }
        int n = inorder.length;
        return build(preorder, inorder, 0, n-1, 0, n-1, map);
    }
    public TreeNode build(int[] preorder, int[] inorder, int preS, int preE, int inS, int inE,
    Map<Integer, Integer> map)
    {
        if(preS>preE || inS>inE)
        return null;

        TreeNode root = new TreeNode(preorder[preS]);

        int inRoot = map.get(root.val);
        int numLeft = inRoot-inS;

        root.left = build(preorder, inorder, preS+1, preS+numLeft, inS, inRoot-1, map);
        root.right = build(preorder, inorder, preS+numLeft+1, preE, inRoot+1, inE, map);

        return root;
    }
}