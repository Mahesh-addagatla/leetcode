class Solution {
    public String largestNumber(int[] nums) {
        int n=nums.length;
        String [] arr=new String[n];
        for(int i=0;i<n;i++){
            arr[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));
        if(arr[0].equals("0")){
            return "0";
        }
        StringBuilder max = new StringBuilder();
        for(String s: arr){
            max.append(s);
        }
        return max.toString();
    }
}
