class Solution {
    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            s = s.replace("AB", "");  // Remove all "AB"
            s = s.replace("CD", "");  // Remove all "CD"
        }
        return s.length();  // Return the remaining length
    }
}
