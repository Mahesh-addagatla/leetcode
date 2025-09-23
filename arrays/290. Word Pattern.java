class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> hm = new HashMap<>();
        String[] str= s.split("\\s+");
        if(pattern.length()!=str.length)return false;
        for(int i =0;i<str.length;i++){
            char c = pattern.charAt(i);
            if(hm.containsKey(c)){
                if(!hm.get(c).equals(str[i]))return false;
            }
            else{
                if(hm.containsValue(str[i])){
                    return false;
                }
                hm.put(c,str[i]);
            }
        }
        return true;
    }
}
