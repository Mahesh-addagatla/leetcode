class Solution {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        if(t.length()!=n)return false;
        HashMap<Character,Integer> hs=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!hs.containsKey(ch)){
                hs.put(ch,1);
            }
            else{
                hs.put(ch,hs.get(ch)+1);
            }
        }
        for(int i=0;i<n;i++){
            char ch=t.charAt(i);
            if(!hs.containsKey(ch))return false;
            else{
                hs.put(ch,hs.get(ch)-1);
            }
        }
        for(Map.Entry<Character,Integer> map : hs.entrySet()){
            int i=map.getValue();
            if(i>0)return false;
        }
        return true;
    }
}
