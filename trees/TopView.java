/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Pair{
    int pos;
    Node node;
    Pair(Node node,int pos){
        this.node=node;
        this.pos=pos;
    }
}

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int pos = p.pos;
            Node node = p.node;
            if(!map.containsKey(pos)){
                map.put(pos,node.data);
            }
            if(node.left!=null)q.add(new Pair(node.left,pos-1));
            if(node.right!=null)q.add(new Pair(node.right,pos+1));
        }
        for(int val : map.values()){
            ans.add(val);
        }
        return ans;
    }
}
