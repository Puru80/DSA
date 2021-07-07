#include <bits/stdc++.h>
using namespace std;

bool searchMatrix(vector<vector<int>>& v, int t){
    int n = v[0].size();
    for(int i=0;i<(int)v.size();i++){
        if(t<=v[i][n-1] && t>=v[i][0]){
            for(int j=0;j<n;j++)
                if(v[i][j]==t)
                    return 1;
        }
    }

    return 0;
}

int main()
{
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif

    int t;
    cin>>t;
    while(t--)
    {
        int r, c;
        cin>>r>>c;
        vector<vector<int>> matrix(r, vector<int>(c));        
        for(int i = 0; i < r; ++i)
            for(int j = 0;j < c; ++j)
                cin>>matrix[i][j];

        int t;
        cin>>t;

        cout<<searchMatrix(matrix, t)<<endl;
    }
    return 0;
}

