class Solution {
    public int[] sortArray(int[] nums) {
        int[] counting = new int[2 * 50000 + 1];
        for (int num : nums) {
            // we add 5 * 10^4 because for smallest possible element -5 * 10^4 index must be 0
            counting[num + 50000]++;
        }
        int writeInd = 0;
        for (int numberInd = 0; numberInd < counting.length; numberInd++) {
            int freq = counting[numberInd];
            while (freq != 0) {
                nums[writeInd] = numberInd - 50000;
                writeInd++;
                freq--;
            }
        }
        return nums;
    }
}
