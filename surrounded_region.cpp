class Solution {
public:
    int n,m;
    bool ok;
    vector<vector<bool>>vis;
    vector<int>dx={-1,0,1,0};
    vector<int>dy={0,1,0,-1};
    bool isvalid(vector<vector<char>>& board,int x,int y){
        if(x<0||x>=m||y<0||y>=n)return false;
        if(vis[x][y]||board[x][y]=='X')return false;
        return true;
    }
    void mark(vector<vector<char>>& board,int i,int j){
       if(i<0 || i>m-1 || j<0 || j>n-1)
            return;
        if(board[i][j]=='X')
            return;
        
        board[i][j] = 'X';
        mark(board,i-1,j);
        mark(board,i+1,j);
        mark(board,i,j-1);
        mark(board,i,j+1);  
    }
    void dfs(vector<vector<char>>& board,int i,int j){
        if(!isvalid(board,i,j))return;
        if(i<=0 || i>=m-1 || j<=0 || j>=n-1) //cell touching the boundary
            ok = true;
        
        vis[i][j] = true;
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }
    void solve(vector<vector<char>>& board) {
        m=board.size(),n=board[0].size();
        if(m<=1)return;
        if(n<=1)return;
        vis.resize(m,vector<bool>(n));
      //iterate over the non boundary cells
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(!vis[i][j]&&board[i][j]=='O'){
                    ok=false;
                    dfs(board,i,j);
                    if(!ok)mark(board,i,j); //ok will be true when any cell of the region touches the boundary.
                    ok=true;
                }
            }
        }
    }
};
