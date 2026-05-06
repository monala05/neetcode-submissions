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

private boolean balanced = true;

class Solution {
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return balanced;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        if(Math.abs(left - right) > 1){
            balanced = false;
        }


        return 1 + Math.max(left, right);
    }
}
