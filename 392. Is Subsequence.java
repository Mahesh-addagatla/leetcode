class Solution {
    public boolean isSubsequence(String s, String t) {
        int idx=0;
        for(char ch : t.toCharArray()){
            if(idx<s.length() && (s.charAt(idx)==ch)){
                idx++;
            }
        }
        return idx==s.length();
    }
}
