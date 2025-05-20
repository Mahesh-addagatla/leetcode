class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        if(n==2)return stones[1]-stones[0];
        int max=0;
        for(int i=0;i<n-1;i++){
            max = Math.max(max,stones[i+1]-stones[i]);
        }
        for(int i=0;i<n-2;i++){
            max = Math.max(max,stones[i+2]-stones[i]);
        }
        return max;
    }
}
