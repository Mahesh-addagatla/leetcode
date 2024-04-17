class Solution {
public:
    void nextPermutation(vector<int>& A) {
    int idx=-1;
    int n=A.size();
    for(int i=n-2;i>=0;i--){
        if(A[i]<A[i+1]){
            idx=i;
            break;
        }
    }
    if(idx==-1){
        reverse(A.begin(),A.end());
        return;
    }
    for(int i=n-1;i>idx;i--){
        if(A[i]>A[idx]){
            swap(A[i],A[idx]);
            break;
        }
    }
    reverse(A.begin()+idx+1,A.end());
    }
};
