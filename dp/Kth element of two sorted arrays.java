import java.util.ArrayList;
public class Solution {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        // Write your coder here
        if(n>m)return kthElement(arr2,arr1,m,n,k);
        int no = (n+m);
        int left = k; 
        int low = Math.max(0, k - m);
        int high = Math.min(k, n);
        while(low<=high){
            int mid1=(low+high)/2;
            // System.out.println(mid1);
            int mid2= left-mid1;
            int r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
            int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
            if(mid1<n)r1=arr1.get(mid1);
            if(mid2<m)r2=arr2.get(mid2);
            if(mid1-1 >=0)l1=arr1.get(mid1-1);
            if(mid2-1>=0)l2=arr2.get(mid2-1);
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }
            else if(l1>r2)high=mid1-1;
            else low=mid1+1;

        }
        return 0;
    }
}
