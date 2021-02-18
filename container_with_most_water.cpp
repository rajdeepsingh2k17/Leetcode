class Solution {
public:
    int maxArea(vector<int>& height) {
        int n=height.size();
        int l=0,r=n-1,m=INT_MIN;
        while(l<r){
            m=max(m,min(height[r],height[l])*(r-l));
            if(height[l]<height[r])l++;
            else r--;
        }
        return m;
    }
};
