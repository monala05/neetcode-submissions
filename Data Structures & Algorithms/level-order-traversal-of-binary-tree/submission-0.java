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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }
        
        List<List<Integer>> q = new ArrayList();

        List<TreeNode> firstLevel = new ArrayList();
        firstLevel.add(root);

        while(!firstLevel.isEmpty()){
            List<Integer> level = new ArrayList();
            List<TreeNode> nextLevel = new ArrayList();

            while(!firstLevel.isEmpty()){
                TreeNode cur = firstLevel.remove(0);
                if(cur.left != null){nextLevel.add(cur.left);}
                if(cur.right != null){nextLevel.add(cur.right);}
                level.add(cur.val);
            }

            q.add(level);
            firstLevel = nextLevel;

        }
        

        return q;
    }
}
