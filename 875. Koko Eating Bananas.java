class Solution {
    public int total(int[] piles,int hours){
        int totalhrs = 0;
        for(int i=0;i<piles.length;i++){
            totalhrs += Math.ceil((double)piles[i]/hours);
        }
        return totalhrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int high = 0;
        for(int i=0;i<n;i++){
            high = Math.max(high,piles[i]);
        }
        int low =1;
        while(low<=high){
            int mid = (low+high)/2;
            int totalhrs = total(piles,mid);
            if(totalhrs<=h){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}
