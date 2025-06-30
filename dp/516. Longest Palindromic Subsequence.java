class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder st = new StringBuilder();
        int n = s.length();
        for(int i = n-1 ; i>=0 ;i--){
            st.append(s.charAt(i));
        }
        String s2 = st.toString();
        // System.out.println(s2);
        int [][] dp = new int[n+1][n+1];
        for(int i = 0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int i = 0;i<=n;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
    }
}
