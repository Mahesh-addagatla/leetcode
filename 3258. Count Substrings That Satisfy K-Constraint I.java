class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int count=0;
        for(int i=0;i<n;i++){
            int zc=0,oc=0;
            for(int j=i;j<n;j++){
                if(s.charAt(j)=='0'){
                    zc++;
                }
                else{
                    oc++;
                }
                if(oc<=k || zc<=k){
                    count++;
                }
            }
        }
        return count;
    }
}
