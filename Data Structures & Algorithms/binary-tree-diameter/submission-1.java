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

private int sum = 0;

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        recurse(root);

        return sum;     
    }

    public int recurse(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = recurse(root.left);
        int right = recurse(root.right);
        sum = Math.max(left + right, sum);
        return 1 + Math.max(left, right);
    }
}
