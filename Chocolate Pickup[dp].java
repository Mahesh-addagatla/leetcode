import java.util.* ;
import java.io.*; 
public class Solution {
	public static int f(int i,int j1,int j2,int c,int r,int[][] grid,int[][][] dp){
		if(j1<0 || j2<0 || j1>=c || j2>=c) return (int)-1e8;
		if(i==r-1){
			if(j1==j2)return grid[i][j1];
			else return grid[i][j1]+grid[i][j2];
		}
		if(dp[i][j1][j2]!=-1)return dp[i][j1][j2];
		int maxi = (int)-1e8;
		for(int dj1=-1;dj1<=1;dj1++){
			for(int dj2=-1;dj2<=1;dj2++){
				int value =0;
				if(j1==j2)value=grid[i][j1];
				else value = grid[i][j1]+grid[i][j2];
				value += f(i+1,j1+dj1,j2+dj2,c,r,grid,dp);
				maxi = Math.max(maxi,value);
			}
		}
		return dp[i][j1][j2] = maxi;
	}
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		int[][][] dp = new int[r][c][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				Arrays.fill(dp[i][j],0);
			}
		}
		for(int i=0;i<c;i++){
			for(int j=0;j<c;j++){
				if(i==j)dp[r-1][i][j] = grid[r-1][j];
				else dp[r-1][i][j] = grid[r-1][i]+grid[r-1][j];
			}
		}
		for(int i=r-2;i>=0;i--){
			for(int j1=0;j1<c;j1++){
				for(int j2=0;j2<c;j2++){
					int maxi=(int)-1e8;
					for(int dj1=-1;dj1<=1;dj1++){
						for(int dj2=-1;dj2<=1;dj2++){
							int value =0;
							if(j1==j2)value=grid[i][j1];
							else value = grid[i][j1]+grid[i][j2];
							if(j1+dj1>=0 && j1+dj1<c && j2+dj2>=0 && j2+dj2<c)value += dp[i+1][j1+dj1][j2+dj2];
							else value = (int)-1e8;
							maxi = Math.max(maxi,value);
						}
					}
					dp[i][j1][j2]=maxi;
				}
			}
		}
		return dp[0][0][c-1];
	}
}
