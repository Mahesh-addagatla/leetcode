import java.util.* ;
import java.io.*; 
public class Solution {
    public static int up(int[] arr,int m,int x){
        int low =0,high=m-1;
        int ans = m;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>x){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static int small(int[][] mat,int n,int m,int num){
        int cnt =0;
        for(int i=0;i<n;i++){
            cnt+=up(mat[i],m,num);
        }
        return cnt;
    }
    public static int findMedian(int arr[][], int n, int m) {
        // Write your code here.
        int low = Integer.MAX_VALUE,high = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            low = Math.min(low,arr[i][0]);
            high = Math.max(high,arr[i][m-1]);
        }
        int req=(m*n)/2;
        while(low<=high){
            int mid = (low+high)/2;
            int smalleq = small(arr,n,m,mid);
            if(smalleq<=req)low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}
