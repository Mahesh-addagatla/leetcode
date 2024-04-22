class Solution {
public:
    bool isPowerOfTwo(int n) {
        if(n==0)return false;
        long long m=n;
        if((m&m-1)==0) return true;
        else return false;
    }
};
