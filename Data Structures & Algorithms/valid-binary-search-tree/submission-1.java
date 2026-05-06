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
        
        return dfs(root, -10000,100000);
    }

    //the trick here is to keep a max/min no left node can be greater than thetop most 
    //ancestor and no rightside node can be less than the top top most ancestor

    public boolean dfs(TreeNode root, int leftBound, int rightBound){
        if(root == null){
            return true;
        }
        // we have to make sure all left tree values are less than max and all right are greater.
        //we update min max as we go
        

        if(root.val >= rightBound || root.val <= leftBound){
            return false;
        }
        
       return dfs(root.left, leftBound, root.val) && dfs(root.right, root.val, rightBound);
    }
}
