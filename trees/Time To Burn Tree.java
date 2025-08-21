/**********************************************************	
	
	Following is the representation of Binary Tree Node:
 	
 	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}

*********************************************************/
import java.util.*;
public class Solution
{
	public static int timeBurn(BinaryTreeNode start,HashMap<BinaryTreeNode,BinaryTreeNode> parent_map){
		HashMap<BinaryTreeNode,Boolean> visited = new HashMap<>();
		Queue<BinaryTreeNode> q = new LinkedList<>();
		int time = 0;
		q.offer(start);
		visited.put(start,true);
		while(!q.isEmpty()){
			int size = q.size();
			int fl=0;
			for(int i=0;i<size;i++){
				BinaryTreeNode cur = q.poll();
				if(cur.left!=null && visited.get(cur.left)==null){
					q.offer(cur.left);
					visited.put(cur.left,true);
					fl=1;
				}
				if(cur.right!=null && visited.get(cur.right)==null){
					q.offer(cur.right);
					visited.put(cur.right,true);
					fl=1;
				}
				if(parent_map.get(cur)!=null && visited.get(parent_map.get(cur))==null){
					q.offer(parent_map.get(cur));
					visited.put(parent_map.get(cur),true);
					fl=1;
				}
			}
			if(fl==1)time++;
		}
		return time;
	}
	public static BinaryTreeNode markParents(HashMap<BinaryTreeNode,BinaryTreeNode> parent_map,BinaryTreeNode root,int start){
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		BinaryTreeNode<Integer> res = new BinaryTreeNode<>(-1);
		while(!q.isEmpty()){
			BinaryTreeNode cur = q.poll();
			if(((int)cur.data) == start)res=cur;
			if(cur.left!=null){
				parent_map.put(cur.left,cur);
				q.offer(cur.left);
			}
			if(cur.right!=null){
				parent_map.put(cur.right,cur);
				q.offer(cur.right);
			}
		}
		return res;
	}
public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
        // Write your code here.
		HashMap<BinaryTreeNode,BinaryTreeNode> parent_map = new HashMap<>();
		BinaryTreeNode startNode = markParents(parent_map,root,start);
		int ans = timeBurn(startNode,parent_map);
		return ans;
    }
}
