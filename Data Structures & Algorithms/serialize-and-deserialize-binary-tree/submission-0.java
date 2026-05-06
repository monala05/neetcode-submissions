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

public class Codec {
    StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] index = new int[1];
        return helper(vals, index);

    }

    public void dfs(TreeNode root){
        if(root == null){
            sb.append("n,");
            return;
        }

        sb.append(root.val).append(',');
        dfs(root.left);
        dfs(root.right);

    }

    public TreeNode helper(String[] vals, int[] index){
        if( index[0] >= vals.length || vals[index[0]].equals("n")){
            index[0]++;
            return null;
        }

        int val = Integer.parseInt(vals[index[0]++]);
        TreeNode root = new TreeNode(val);
        root.left = helper(vals, index);
        root.right = helper(vals, index);

        return root;
    }
}
