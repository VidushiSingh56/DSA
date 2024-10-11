import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node == null) {
                s.append("null,");
            } else {
                s.append(node.val).append(",");
                que.offer(node.left);
                que.offer(node.right);
            }
        }
        return s.toString();
    }
    public TreeNode deserialize(String data) 
    {
        if (data.equals("null")) return null;
        
        String[] nodes = data.split(",");
        Queue<TreeNode> que = new LinkedList<>();
        
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        que.offer(root);
        
        int i = 1;
        while (!que.isEmpty() && i < nodes.length) {
            TreeNode node = que.poll();
            if (!nodes[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(nodes[i]));
                que.offer(node.left);
            }
            i++;
            
            if (i < nodes.length && !nodes[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                que.offer(node.right);
            }
            i++;
        }
        return root;
    }
}

// Usage:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
