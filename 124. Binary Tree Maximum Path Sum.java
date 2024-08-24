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
    int sum=Integer.MIN_VALUE;
    public int findMaxPathSum(TreeNode root){
        if(root==null)return 0;
        int leftsum=Math.max(0,findMaxPathSum(root.left));
        int rightsum=Math.max(0,findMaxPathSum(root.right));
        sum=Math.max(sum,leftsum+rightsum+root.val);
        return root.val+Math.max(leftsum,rightsum);
    }
    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return sum;
    }
}
