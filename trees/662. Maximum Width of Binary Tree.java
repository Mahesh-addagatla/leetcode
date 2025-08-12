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
class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node,int num){
        this.node = node;
        this.num=num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        int ans =0;
        while(!q.isEmpty()){
            int size = q.size();
            int left=0,right=0;
            int nmin=q.peek().num;
            for(int i=0;i<size;i++){
                TreeNode node = q.peek().node;
                int cur_min = q.peek().num-nmin;
                q.poll();
                if(i==0){
                    left = cur_min;
                }
                if(i==size-1){
                    right = cur_min;
                }
                if(node.left!=null)q.offer(new Pair(node.left,cur_min*2+1));
                if(node.right!=null)q.offer(new Pair(node.right,cur_min*2+2));
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}
