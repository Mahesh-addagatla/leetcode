
class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platforms=0;
        int ans=1;
        int i=0,j=0;
        while(i<arr.length && j < dep.length){
            if(arr[i]<=dep[j]){
                platforms++;
                i++;
            }
            else{
                platforms--;
                j++;
            }
            ans = Math.max(platforms,ans);
        }
        return ans;
        
    }
}
