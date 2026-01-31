class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length-1;
        char ans = letters[0];
        while(low<=high){
            int mid = low+(high-low)/2;
            System.out.println(mid);
            if(letters[mid]>target){
                ans = letters[mid];
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }
}
