import java.util.*;
class Solution {
    public int strStr(String haystack, String needle) {
        int n=needle.length();
        String [] st=haystack.split("(?<=\\G.{n})");
        for(int i=0;i<st.length;i++){
            if(st[i]==needle) return 0;
        }
        return -1;
    }
}
