class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int c=0;
        int res=0;
        for(int i : hm.keySet()){
            if(hm.get(i)>c){
                c=hm.get(i);
                res=hm.get(i);
            }
            else if(hm.get(i)==c){
                res+=hm.get(i);
            }
        }
        return res;
    }
}
