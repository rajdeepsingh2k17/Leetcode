
class Solution {
public:
    int n,m;
    vector<vector<bool>>vis;
    vector<int> dx={-1,0,1,0};
    vector<int> dy={0,1,0,-1};
    bool isvalid(vector<vector<char>>& grid,int x,int y){
        if(x<0||x>=n||y<0||y>=m)return false;
        if(vis[x][y]==1||grid[x][y]=='0')return false;
        return true;
    }
    void dfs(vector<vector<char>>& grid,int x,int y){
        vis[x][y]=1;
        for(int i=0;i<4;i++){
            if(isvalid(grid,x+dx[i],y+dy[i]))dfs(grid,x+dx[i],y+dy[i]);
        }
    }
    int numIslands(vector<vector<char>>& grid) {
        n=grid.size(),m=grid[0].size();
        vis.resize(n,vector<bool>(m));
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'&&vis[i][j]==0)dfs(grid,i,j),count++;
            }
        }
        return count;
    }
};
