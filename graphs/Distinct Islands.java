import java.util.*;
public class Solution 
{
	public static String toString(int r,int c){
		return Integer.toString(r) +" "+Integer.toString(c);
	}
	public static void dfs(int r,int c,int[][] vis,int[][] arr,ArrayList<String> vec,int br,int bc){
		vis[r][c] = 1;
		vec.add(toString(br-r,bc-c));

		int n=arr.length;
		int m = arr[0].length;
		int[] delrow = {-1,0,1,0};
		int[] delcol = {0,1,0,-1};
		for(int i=0;i<4;i++){
			int dr = r+delrow[i];
			int dc = c+delcol[i];
			if(dr>=0 && dr<n && dc>=0 && dc<m && arr[dr][dc]==1 && vis[dr][dc]!=1){
				dfs(dr,dc,vis,arr,vec,br,bc);
			}
		}
	}
	public static int distinctIsland(int [][] arr, int n, int m) 
	{
		//write your code here
		int[][] vis = new int[n][m];
		HashSet<ArrayList<String>> hs = new HashSet<>();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(vis[i][j]!=1 && arr[i][j]==1){
					ArrayList<String> vec = new ArrayList<>();
					dfs(i,j,vis,arr,vec,i,j);
					hs.add(vec);
				}
			}
		}
		return hs.size();
	}
}
