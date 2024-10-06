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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        if (root == null) {
            return list; // Return an empty list if the root is null
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if(i==0)list.add(node.val);

                // Offer right child first, then left child
                if (node.right != null) {
                    que.offer(node.right);
                }
                if (node.left != null) {
                    que.offer(node.left);
                }
            }
        }
        return list;
    }
}
