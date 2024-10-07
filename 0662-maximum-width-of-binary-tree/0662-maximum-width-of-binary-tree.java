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
 class Pair
 {
    TreeNode node;
    int num;
    public Pair(TreeNode _node, int num)
    {
        node = _node;
        this.num = num;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) 
    {
        if(root == null)
        return 0;
        int ans=0;
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(root, 0));
        while(!que.isEmpty())
        {
            int size = que.size();
            int min = que.peek().num;
            int first =0,last=0;
            for(int i =0;i<size;i++)
            {
                int cur = que.peek().num - min;
                TreeNode node = que.peek().node;
                que.poll();
                // list.add(node.val);
                if(i==0)first = cur;
                if(i==size-1)last = cur;
                if(node.left!=null)que.offer(new Pair(node.left, cur*2 + 1));
                if(node.right!=null)que.offer(new Pair(node.right, cur*2 + 2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}