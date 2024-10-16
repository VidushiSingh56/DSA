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
// class Solution {
//     TreeNode prev = null;
//     public void flatten(TreeNode root) 
//     {
//         if(root == null)
//         return;

//         flatten(root.right);//right 
//         flatten(root.left);//left

//         root.right = prev;//root
//         root.left = null;
//         prev = root;
//     }
// }
class Solution {
    public void flatten(TreeNode root) 
    {
        if(root == null)
        return;
       Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty())
        {
            TreeNode cur = st.pop();
            if(cur.right != null)
            st.push(cur.right);

            if(cur.left != null)
            st.push(cur.left);

            if(!st.isEmpty()){
                cur.right = st.peek();
            }
            cur.left = null;
        }
    }
}