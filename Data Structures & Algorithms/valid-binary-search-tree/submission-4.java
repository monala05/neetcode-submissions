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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, -1000000, 1000000);
    }

    public boolean dfs(TreeNode root, int left, int right){
        if(root == null){
            return true;
        }


        if(root.val >= right || root.val <= left){
            return false;
        }

        return dfs(root.left, left, root.val) && dfs(root.right, root.val, right);
    }
}
