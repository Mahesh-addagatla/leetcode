class Solution {
    public int f(String s, String t,int n1,int n2,int[][] dp){
        if(n2<0)return 1;
        if(n1<0)return 0;
        if(dp[n1][n2]!=-1)return dp[n1][n2];
        if(s.charAt(n1)==t.charAt(n2)){
            return dp[n1][n2] = f(s,t,n1-1,n2-1,dp)+f(s,t,n1-1,n2,dp);
        }
        return dp[n1][n2] = f(s,t,n1-1,n2,dp);
    }
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1<n2)return 0;
        int[][] dp = new int[n1][n2];
        for(int i=0;i<n1;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(s,t,n1-1,n2-1,dp);
    }
}
