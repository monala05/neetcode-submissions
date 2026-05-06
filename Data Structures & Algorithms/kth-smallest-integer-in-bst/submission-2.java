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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){return -1;}
        Stack<TreeNode> s = new Stack();
        TreeNode cur = root;

        while(!s.isEmpty() || cur != null){
            while(cur != null){
                s.push(cur);
                cur = cur.left;
            }
            TreeNode back = s.pop();
            k--;

            if(k == 0){return back.val;}
            cur = back.right;
        }

        return -1;
    }


}


