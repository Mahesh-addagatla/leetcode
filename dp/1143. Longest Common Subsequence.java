class Solution {
    public int lcs(int n,int m,String s1, String s2,int[][] dp){
        if(n<0 || m<0){
            return 0;
        }
        if(dp[n][m]!=-1)return dp[n][m];
        if(s1.charAt(n)==s2.charAt(m))return dp[n][m] = 1+lcs(n-1,m-1,s1,s2,dp);
        return dp[n][m] = Math.max(lcs(n-1,m,s1,s2,dp),lcs(n,m-1,s1,s2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m+1];
        int[] cur = new int[m+1];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // for(int i=0;i<=n;i++){
        //     dp[i][0]=0;
        // }
        // for(int i=0;i<=m;i++){
        //     prev[i]=0;
        // }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))cur[j] = 1+prev[j-1];
                else cur[j] = Math.max(prev[j],cur[j-1]);
            }
            prev = cur.clone();
        }
        return prev[m];
    }
}
