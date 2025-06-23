import java.util.*;
public class Solution {
	public static int canCut(int[] price,int ind,int size,int[][] dp){
		if (ind == 0) {
			return size * price[0]; // works for size = 0 too (0 * price[0] = 0)
		}
		if(dp[ind][size]!=-1)return dp[ind][size];
		int notcut = 0 + canCut(price,ind-1,size,dp);
		int cut = 0;
		if((ind+1)<=size){
			cut = price[ind]+canCut(price,ind,size-(ind+1),dp);
		}
		return dp[ind][size]=Math.max(notcut,cut);
	}
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[][] dp = new int[n][n+1];
		for(int i=0;i<n;i++){
			Arrays.fill(dp[i],-1);
		}
		return canCut(price,n-1,n,dp);
	}
}
