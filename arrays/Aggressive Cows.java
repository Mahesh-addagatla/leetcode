import java.util.*;
public class Solution {
    public static boolean canWePlace(int[] st,int mi,int cows,int n){
        int cc = 1,last = st[0];
        for(int i=0;i<n;i++){
            if(st[i]-last>=mi){
                cc++;
                last =st[i];
            }
            if(cc==cows){
                return true;
            }
        }
        return false;
    }
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int n = stalls.length;
        int high = stalls[n-1]-stalls[0];
        int low = 1;
        // for(int i=1;i<=maxi;i++){
        //     if(canWePlace(stalls,i,k,n)){
        //         continue;
        //     }
        //     else{
        //         return i-1;
        //     }
        // }
        while(low<=high){
            int mid = (low+high)/2;
            if(canWePlace(stalls,mid,k,n)){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return high;
    }
}
