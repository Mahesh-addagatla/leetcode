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
    public int findLeftHeight(TreeNode root){
        int lh=0;
        while(root!=null){
            lh++;
            root=root.left;
        }
        return lh;
    }
    public int findRightHeight(TreeNode root){
        int rh=0;
        while(root!=null){
            rh++;
            root=root.right;
        }
        // System.out.println(rh);
        return rh;
    }
    public int countNodes(TreeNode root) {
        if(root == null)return 0;
        int lh = findLeftHeight(root);
        int rh = findRightHeight(root);

        if(lh==rh)return (1<<lh)-1;

        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
