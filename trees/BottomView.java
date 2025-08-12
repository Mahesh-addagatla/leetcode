/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    
     TreeNode(int val) {
         this.val = val;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

import java.util.*;
class Pair{
    int pos;
    TreeNode node;
    Pair(int pos,TreeNode node){
        this.pos=pos;
        this.node=node;
    }
}
public class Solution {
    public static List<Integer> bottomView(TreeNode root) {
        // Write your code here.  
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer,Integer> hs = new TreeMap<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair temp = q.poll();
            TreeNode node = temp.node;
            int pos = temp.pos;
            hs.put(pos,node.val);
            if(node.left!=null){
                q.add(new Pair(pos-1,node.left));
            }
            if(node.right!=null){
                q.add(new Pair(pos+1,node.right));
            }
        } 
        for(int val : hs.values()){
            ans.add(val);
        }  
        return ans;    
    }
}
