class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int targetIdx=0,targetLen=str2.length();
        for(char ch: str1.toCharArray()){
            if(targetIdx<targetLen && (str2.charAt(targetIdx)-ch+26)%26<=1){
                targetIdx++;
            }
        }
        return targetIdx==targetLen;
    }
}
