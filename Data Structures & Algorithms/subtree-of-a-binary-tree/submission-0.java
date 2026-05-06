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

public boolean ans = false;

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        dfs(root, subRoot);
        return ans;
    }
    public void dfs(TreeNode root, TreeNode subRoot){
        if(root == null){return;}

        dfs(root.left, subRoot);
        dfs(root.right, subRoot);
        boolean cur = isSameTree(root, subRoot);

        if(cur == true){ans = true;}
    }

    public boolean isSameTree(TreeNode p, TreeNode q){
         if(p == null && q == null){
            return true;
        }

        if(p == null && q != null || q == null && p != null || p.val != q.val){
            return false;
        }else{
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
