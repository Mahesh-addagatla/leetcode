class Solution {
    public int minimumDeletions(String s) {
        int c=0,ans=0;
        for(char ch:s.toCharArray()){
            if(ch=='b')c++;
            else if(c!=0){
                ans++;
                c--;
            }
        }
        return ans;
    }
}
