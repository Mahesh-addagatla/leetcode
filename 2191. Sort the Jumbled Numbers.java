class Solution {
    public static int getValue(int num,int[] mapping){
        if(num==0)return mapping[0];
        int res=0;
        int cur=1;
        while(num>0){
            int r=num%10;
            num/=10;
            res+=mapping[r]*cur;
            cur*=10;
        }
        return res;
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int num:nums){
            if(!hs.containsKey(num)){
                hs.put(num,getValue(num,mapping));
            }
        }
        Integer[] numsBoxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsBoxed,(a,b)-> Integer.compare(hs.get(a),hs.get(b)));

        for(int i=0;i<nums.length;i++){
            nums[i]=numsBoxed[i];
        }
        return nums;

    }
}
