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
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }  

        //Need to check the value of the left and right
        //At each node we need to check if adding the left and the right will increase our max at node
        // The max at each node is the max of the left node + the max of right node plus cur val
        // Our max can be furthere defined by saying if left and right subtract from max we dont add them
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        int curMax = root.val + left + right;

        ans = Math.max(ans, curMax);

        return Math.max(root.val + left, root.val + right);
    }
}
