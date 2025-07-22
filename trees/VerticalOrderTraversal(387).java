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

class Tuple{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode _node,int _row,int _col){
        node = _node;
        row = _row;
        col = _col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> q = new LinkedList<Tuple>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple t = q.poll();
            TreeNode node = t.node;
            int x = t.row,y=t.col;

            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);

            if(node.left!=null)q.offer(new Tuple(node.left,x-1,y+1));
            if(node.right!=null)q.offer(new Tuple(node.right,x+1,y+1));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> y : map.values()){
            List<Integer> a = new ArrayList<>();
            for(PriorityQueue<Integer> p : y.values()){
                while(!p.isEmpty()){
                    a.add(p.poll());
                }
            }
            ans.add(a);
        }
        return ans;
    }
}