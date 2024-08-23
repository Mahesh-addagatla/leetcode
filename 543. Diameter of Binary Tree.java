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
    int dia=0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return dia-1;
    }
    public int dfs(TreeNode root){
        if(root==null)return 0;
        int ld=dfs(root.left);
        int rd=dfs(root.right);
        int d=ld+rd+1;
        dia=Math.max(d,dia);
        return Math.max(ld,rd)+1;
    }
}
