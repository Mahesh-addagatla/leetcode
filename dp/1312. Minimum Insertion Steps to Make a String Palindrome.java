class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder st = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            st.append(s.charAt(i));
        }
        String s2 = st.toString();
        int[] prev = new int[n+1];
        int[] cur = new int[n+1];
        for(int i=1;i<n+1;i++){
            for(int j =1;j<=n;j++){
                if(s.charAt(i-1)==s2.charAt(j-1))cur[j] = 1+prev[j-1];
                else cur[j] = Math.max(prev[j],cur[j-1]); 
            }
            prev = cur.clone();
        }
        return n-prev[n];
    }
}
