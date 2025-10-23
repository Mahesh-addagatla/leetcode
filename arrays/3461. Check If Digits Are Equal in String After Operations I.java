class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length()>2){
            StringBuilder str = new StringBuilder();
            for(int i=1;i<s.length();i++){
                int a = ((s.charAt(i-1)-'0')+(s.charAt(i)-'0'))%10;
                str.append(a);
            }
            s = str.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}
