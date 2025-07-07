class Solution {
    public boolean f(int i,int j , String s,String p,boolean[][] dp){
        if(i<0 && j<0)return true;
        if(j<0 && i>=0)return false;
        if(i<0 && j>=0){
            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*')return false;
            }
            return true;
        }
        if(dp[i][j]!=false) return dp[i][j];
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')return dp[i][j] = f(i-1,j-1,s,p,dp);
        if(p.charAt(j)=='*'){
            return dp[i][j] = f(i-1,j,s,p,dp)||f(i,j-1,s,p,dp);
        }
        return dp[i][j] = false;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i=1;i<=n;i++){
            dp[i][0]=false;
        }
        for(int j=1;j<=m;j++){
            boolean f=true;
            for(int k=1;k<=j;k++){
                if(p.charAt(k-1)!='*'){
                    f=false;
                    break;
                }
            }
            dp[0][j]=f;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j]||dp[i][j-1];
                }
                else dp[i][j] = false;
            }
        }
        return dp[n][m];
    }
}
