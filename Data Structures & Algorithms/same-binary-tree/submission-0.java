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

private boolean even = true;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p, q);
        return even;
    }

    public void dfs(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return;
        }

        if(p == null && q != null || q == null && p != null){
            even = false;
            return;
        }

        dfs(p.left, q.left);
        dfs(p.right, q.right);

        if(p.val != q.val){even = false; }

    }
}
