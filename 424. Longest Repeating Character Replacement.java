class Solution {
    public int characterReplacement(String s, int k) {
        int freq=0;
        int l=0,r=0;
        int maxlen=0;
        int[] arr=new int[26];
        for(r=0;r<s.length();r++){
            arr[s.charAt(r)-'A']++;
            freq=Math.max(freq,arr[s.charAt(r)-'A']);
            if(r-l+1-freq>k){
                arr[s.charAt(l)-'A']--;
                l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}
