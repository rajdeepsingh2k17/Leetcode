class Solution {
public:
    int maximumPopulation(vector<vector<int>>& logs) {
        int pop[101]={0},res=0;
        for(auto &i:logs){
            pop[i[0]-1950]++;
            pop[i[1]-1950]--;
        }
        for(int i=1;i<101;i++){pop[i]+=pop[i-1];
                              if(pop[i]>pop[res])res=i;}
        
       return res+1950; 
    }
};
