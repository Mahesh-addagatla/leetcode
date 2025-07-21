import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static int low_bound(ArrayList<Integer> arr,int k){
        int low =0, high = arr.size();
        while(low<=high){
            int mid = (low+high)/2;
            if(arr.get(mid)==k)return mid;
            else if(arr.get(mid)>k)high = mid-1;
            else low = mid+1;
        }
        return low;
    }
	
    public static int LIS(ArrayList<Integer> heights, int n)  {
        // Write your code here.   
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(heights.get(0));    
        for(int i=1;i<n;i++){
            if(heights.get(i)>ans.get(ans.size()-1)){
                ans.add(heights.get(i));
            }
            else{
                int idx = low_bound(ans,heights.get(i));
                ans.set(idx,heights.get(i));
            }
        } 
        return ans.size();    
    }
}
