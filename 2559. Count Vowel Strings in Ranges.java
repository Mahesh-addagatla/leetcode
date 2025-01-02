class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=words.length;
        int[] Prefix = new int[n+1];
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        for(int i=0 ; i<n ; i++){
            Prefix[i+1]=Prefix[i];
            if(vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length()-1))){
                Prefix[i+1]++;
            }
        }
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i]=Prefix[queries[i][1]+1] - Prefix[queries[i][0]];
        }
        return ans;
    }
}
