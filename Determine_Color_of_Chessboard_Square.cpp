class Solution {
public:
    bool squareIsWhite(string c) {
        int t=c[0]-'a';
        if((t+c[1])%2==0)return true;
        return false;
        
    }
};
