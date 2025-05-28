import java.util.* ;
import java.io.*; 

public class Solution {
    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
      // Wriute your code here.
      int floor = -1;
      int ceil=-1;
      int low=0,high = n-1;
      int low2=0,high2=n-1;
      while(low<=high){
        int mid = (low+high)/2;
        if(arr[mid]>=x){
          ceil = arr[mid];
          high = mid-1;
        }
        else low = mid+1;
      }
      while(low2<=high2){
        int mid = (low2+high2)/2;
        if(arr[mid]<=x){
          floor = arr[mid];
          low2 = mid+1;
        }
        else high2 = mid-1;
      }

   // System.out.println(floor +"" + ceil);
    return new int[]{floor, ceil};
    }  
}
