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
    int sum=0;
    int totalsum=0;
    public int sumNumbers(TreeNode root) {
        if(root==null)return root.val;
        sumNumbers1(root,sum);
        return totalsum;
    }
    public void sumNumbers1(TreeNode root,int sum){
        if(root==null)return ;
        sum=sum*10+root.val;
        if(root.left==null && root.right==null){
            totalsum+=sum;
            return;
        }
        sumNumbers1(root.left,sum);
        sumNumbers1(root.right,sum);
    }
}
