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
    public TreeNode ans = null;
    public TreeNode p;
    public TreeNode q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {  
        this.p = p;
        this.q = q;

        dfs(root);
        return ans;
    }

    public boolean dfs(TreeNode root){
        if(root == null){
            return false;
        }

        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        boolean match = false;

        if(root.val == p.val || root.val == q.val){match = true;}

        if(left && right || left && match || right && match){ans = root;}

        return match || left || right;
    }
    
}
