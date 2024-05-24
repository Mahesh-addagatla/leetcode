class Solution {
public:
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        vector<int> count(26,0);
        vector<int> lettersCount(26,0);
        for(auto &c: letters){
            count[c-'a']++;
        }
        int ans=0;
        backtrack(words,score,count,lettersCount,0,0,ans);
        return ans;
    }
    void backtrack(vector<string>& words,vector<int>& score,vector<int>& count,vector<int>& lettersCount,int pos,int temp,int &ans){
        for(int i=0;i<26;i++){
            if(count[i]<lettersCount[i])return;
        }
        ans=max(temp,ans);
        for(int i=pos;i<words.size();i++){
            for(auto &c:words[i]){
                lettersCount[c-'a']++;
                temp+=score[c-'a'];
            }
            backtrack(words,score,count,lettersCount,i+1,temp,ans);
            for(auto &c:words[i]){
                lettersCount[c-'a']--;
                temp-=score[c-'a'];
            }
        }
    }
};
