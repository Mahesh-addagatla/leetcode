class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> hs = new HashMap<>();
        char st[] = s.toCharArray();
        for(char c : st){
            hs.put(c,hs.getOrDefault(c,0)+1);
        }
        for(int i=0;i<st.length;i++){
            if(hs.get(st[i])==1){
                return i;
            }
        }
        return -1;
    }
}
