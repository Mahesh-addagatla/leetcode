class Solution {
public:
    int generateKey(int num1, int num2, int num3) {
    string res = "", s = "0000";
    string s1 = to_string(num1), s2 = to_string(num2), s3 = to_string(num3);
    s1 = s.substr(0, s.size() - s1.size()) + s1;
    s2 = s.substr(0, s.size() - s2.size()) + s2;
    s3 = s.substr(0, s.size() - s3.size()) + s3;
    for(int i = 0; i < s.size(); i++) res += min({s1[i], s2[i], s3[i]});
    return stoi(res);
}
};
