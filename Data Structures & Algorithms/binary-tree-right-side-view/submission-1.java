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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList();
        if(root == null){
            return ans; 
        }

        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while(!q.isEmpty()){
            Queue<TreeNode> second = new LinkedList(q);
            q.clear();
            while(!second.isEmpty()){
                TreeNode cur = second.remove();
                
                if(cur.left != null){q.offer(cur.left);}
                if(cur.right != null){q.offer(cur.right);}

                if(second.isEmpty()){
                    ans.add(cur.val);
                }
            }
        }

        return ans;
    }
}
