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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);

        boolean rev = false;

        while(!dq.isEmpty()){
            int levelSize = dq.size();
            List<Integer> curr = new ArrayList<>();
            
            for(int i= 0;i<levelSize;i++){
                if(!rev){
                    TreeNode currNode =  dq.pollFirst();
                    curr.add(currNode.val);
                    if(currNode.left!=null){
                        dq.addLast(currNode.left);
                    }
                    if(currNode.right!=null){
                        dq.addLast(currNode.right);
                    }
                }
                else{
                    TreeNode currNode =  dq.pollLast();
                    curr.add(currNode.val);
                    if(currNode.right!=null){
                        dq.addFirst(currNode.right);
                    }
                    if(currNode.left!=null){
                        dq.addFirst(currNode.left);
                    }
                }
            }
        rev = !rev;
        res.add(curr);
        }
        return res;
    }
}
