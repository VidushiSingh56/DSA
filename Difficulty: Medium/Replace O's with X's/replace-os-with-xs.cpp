// User function Template for C++

class Solution {
  public:
  
    int dr[4] = {-1, 0, 0, 1};
    int dc[4] = {0, -1, 1, 0};
    
    bool valid(int i, int j, int m, int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
    
    vector<vector<char>> fill(vector<vector<char>>& mat) {
        // code here
        int m = mat.size();
        int n = mat[0].size();
        
        queue<pair<int, int>> q;
        
        // top
        for(int j=0; j<n; j++){
            if(mat[0][j] == 'O'){
                q.push({0, j});
                mat[0][j]= 'T';
            }
        }
        
        // right
        for(int i=1; i<m; i++){
            if(mat[i][n-1] == 'O'){
                q.push({i, n-1});
                mat[i][n-1]= 'T';
            }
        }
        
        // bottom
        for(int j=0; j<n-1; j++){
            if(mat[m-1][j] == 'O'){
                q.push({m-1, j});
                mat[m-1][j]= 'T';
            }
        }
        
        // left
        for(int i=1; i<m-1; i++){
            if(mat[i][0] == 'O'){
                q.push({i, 0});
                mat[i][0]= 'T';
            }
        }
        
        while(!q.empty()){
            int x = q.front().first;
            int y = q.front().second;
            
            q.pop();
            
            for(int d=0; d<4; d++){
                int r = x + dr[d];
                int c = y + dc[d];
                
                if(valid(r, c, m, n) && mat[r][c] == 'O'){
                    q.push({r, c});
                    mat[r][c] = 'T';
                }
            }
            
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 'O'){
                    mat[i][j] = 'X';
                }
                else if(mat[i][j] == 'T'){
                    mat[i][j] = 'O';
                }
            }
        }
      
      return mat;  
    }
};