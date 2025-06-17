class Solution {
    public int f(int[] weights,int c,int n){
        int load=0,days=1;
        for(int i=0;i<n;i++){
            if(load+weights[i]>c){
                days+=1;
                load = weights[i];
            }
            else{
                load+=weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int mini = 0,sum=0;
        for(int i=0;i<n;i++){
            mini = Math.max(mini,weights[i]);
            sum+=weights[i];
        }
        while(mini <= sum){
            int mid = (mini+sum)/2;
            int daysReq = f(weights,mid,n);
            if(daysReq<=days){
                sum=mid-1;
            }
            else{
                mini = mid+1;
            }

        }
        // for(int i=mini;i<=sum;i++){
        //     int daysReq = f(weights,i,n);
        //     if(daysReq<=days)return i;
        // }
        return mini;
    }
}
