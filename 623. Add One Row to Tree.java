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
    public TreeNode new1(TreeNode root,int val,int depth,int curdep){
        if(root==null)return null;
        if(curdep==depth-1){
            TreeNode ltemp=root.left;
            TreeNode rtemp=root.right;

            root.left=new TreeNode(val);
            root.right=new TreeNode(val);

            root.left.left=ltemp;
            root.right.right=rtemp;
            return root;
        }
        root.left=new1(root.left,val,depth,curdep+1);
        root.right=new1(root.right,val,depth,curdep+1);

        return root;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newroot=new TreeNode(val);
            newroot.left=root;
            return newroot;
        }
        return new1(root,val,depth,1);
    }
}
