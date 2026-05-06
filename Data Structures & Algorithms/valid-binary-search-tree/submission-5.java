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
        
        return dfs(root, -100000,10000);
    }

    public boolean dfs(TreeNode root, int leftBound, int rightBound){
        if(root == null){
            return true;
        }

        if(root.val >= rightBound || root.val <= leftBound){
            return false;
        }


        return dfs(root.left, leftBound, root.val) && dfs(root.right, root.val, rightBound);
    }
}
