class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (high+low)/2;
            if(nums[mid]==target)return true;
            if(nums[low]== nums[mid]&& nums[mid]==nums[high]){
                high--;
                low++;
            }
            else if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target <= nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            else{
                if(nums[mid]<=target && target<=nums[high] ){
                    low = mid+1;
                }else high = mid-1;
            }
        }
        return false;
    }
}



// class Solution {
//     public boolean search(int[] nums, int target) {
//         int low = 0, high = nums.length - 1;

//         while (low <= high) {
//             int mid = low + (high - low) / 2;

//             if (nums[mid] == target) return true;

//             // Skip duplicates
//             if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
//                 low++;
//                 high--;
//             }
//             // Left half is sorted
//             else if (nums[low] <= nums[mid]) {
//                 if (nums[low] <= target && target < nums[mid]) {
//                     high = mid - 1;
//                 } else {
//                     low = mid + 1;
//                 }
//             }
//             // Right half is sorted
//             else {
//                 if (nums[mid] < target && target <= nums[high]) {
//                     low = mid + 1;
//                 } else {
//                     high = mid - 1;
//                 }
//             }
//         }

//         return false;
//     }
// }
