class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        int cur = n;
        while(!hs.contains(cur)){
            hs.add(cur);
            int sum = 0;
            while(cur>0){
                int d = cur%10;
                sum += Math.pow(d,2);
                cur = cur/10;
            }
            // System.out.println(sum);
            if(sum==1)return true;
            cur=sum;
        }
        return false;
    }
}
