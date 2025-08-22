/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParents(TreeNode root,Map<TreeNode,TreeNode> parent_map){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.left!=null){
                q.offer(cur.left);
                parent_map.put(cur.left,cur);
            }
            if(cur.right!=null){
                q.offer(cur.right);
                parent_map.put(cur.right,cur);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent_map = new HashMap<>();
        markParents(root,parent_map);
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode,Boolean> visited = new HashMap<>();
        q.offer(target);
        visited.put(target,true);
        int cur_level =0;
        while(!q.isEmpty()){
            int size = q.size();
            if(cur_level == k)break;
            cur_level++;
            for(int i=0;i<size;i++){
                TreeNode current = q.poll();
                if(current.left!=null && visited.get(current.left)==null){
                    visited.put(current.left,true);
                    q.offer(current.left);
                }
                if(current.right!=null && visited.get(current.right)==null){
                    visited.put(current.right,true);
                    q.offer(current.right);
                }
                if(parent_map.get(current)!=null && visited.get(parent_map.get(current))==null){
                    visited.put(parent_map.get(current),true);
                    q.offer(parent_map.get(current));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            ans.add(cur.val);
        }
        return ans;
    }
}
