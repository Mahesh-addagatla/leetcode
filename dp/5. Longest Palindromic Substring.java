class Solution {
    public String palinString(String s,int left,int right){
        while(left>=0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            right++;
            left--;
        }
        return s.substring(left+1,right);
    }
    public String longestPalindrome(String s) {
        if(s.length()<=1)return s;
        String maxPalin = s.substring(0,1);
        for(int i=0;i<s.length();i++){
            String even = palinString(s,i,i);
            String odd = palinString(s,i,i+1);
            if(even.length()>= maxPalin.length()){
                maxPalin = even;
            }
            if(odd.length() >= maxPalin.length()){
                maxPalin = odd;
            }
        }
        return maxPalin;
    }
}
