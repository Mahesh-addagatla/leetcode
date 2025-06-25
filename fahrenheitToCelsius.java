
import java.util.* ;
import java.io.*; 

public class Solution {

	public static List<List<Integer>> fahrenheitToCelsius(int s, int e, int w) {
		// Write your code here
		List<List<Integer>> ans = new ArrayList<>();
		for(int i=s;i<=e;i+=w){
			List<Integer> a = new ArrayList<>();
			a.add(i);
			int c = (int)((i-32)*(5.0/9));
			a.add(c);
			ans.add(a);
		}
		return ans;
	}

}
