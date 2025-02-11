class Solution {
    public String removeOccurrences(String s, String part) {
        char[] str= s.toCharArray();
        char[] par = part.toCharArray();
        char[] st = new char[s.length()];
        int stsize=0, parlen=par.length;
        int tarchar = par[parlen-1];
        for(char c : str){
            st[stsize++] = c;
            if(c == tarchar && stsize>=parlen){
                int i=stsize-1,j=parlen-1;
                while(j>=0 && st[i]==par[j]){
                    j--;
                    i--;
                }
                if(j<0){
                    stsize = i+1;
                }
            }
        }
        return new String(st,0,stsize);
    }
}
