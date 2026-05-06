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
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        dfs(root, maxHeap, k);
        return maxHeap.peek();
    }

    public void dfs(TreeNode root, PriorityQueue<Integer> s, int k){
        if(root == null){
            return;
        }
        
        s.offer(root.val);
        if(s.size() > k){
            s.remove();
        }

        dfs(root.left, s, k);
        dfs(root.right, s, k);
    }
}
