class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int c = target[0];
        for(int i=1;i<n;i++){
            if(target[i]>target[i-1]){
                c+=Math.max(target[i]-target[i-1],0);
            }
        }
        return c;
    }
}
