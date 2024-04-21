import java.util.*;

public class Solution {
    
	public static void reverseStack(Stack<Integer> stack) {
		// write your code here
		Queue<Integer> ans=new LinkedList<Integer>();
		while(!stack.isEmpty()){
			ans.add(stack.pop());
		}
		while(!ans.isEmpty()){
			stack.push(ans.poll());
		}
	}

}
