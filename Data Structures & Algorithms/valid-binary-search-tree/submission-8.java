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
        
        return dfs(root, -1001,1001);
    }

    public boolean dfs(TreeNode root, int l, int r){
        if(root == null){
            return true;
        }

        boolean left = dfs(root.left, l, root.val);
        boolean right = dfs(root.right, root.val, r);

        return root.val < r && root.val > l && left && right;
    }
}
