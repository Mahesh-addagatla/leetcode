import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int k) {
		// Write your code here.
		HashMap<Integer,Integer> hs = new HashMap<>();
		int xr=0;
		hs.put(xr,1);
		int c=0;
		for(int i : arr){
			xr = xr ^ i;
			int x = xr^k;
			if(hs.containsKey(x))c+=hs.get(x);
			hs.put(xr,hs.getOrDefault(xr,0)+1);
		}
		return c;
	}
}
