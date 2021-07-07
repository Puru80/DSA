#include <bits/stdc++.h>
using namespace std;

int median(vector<vector<int>> &m, int r, int c){
    int mn = INT_MAX, mx = INT_MIN;
    for (int i=0; i<r; i++)
    {
        mn = min(m[i][0], mn);
        mx = max(m[i][c-1], mx);
    }

    int desired = (r * c + 1) / 2;
    while (mn < mx)
    {
        int mid = mn + (mx - mn) / 2;
        int place = 0;
 
        // Find count of elements smaller than mid
        for (int i = 0; i < r; ++i)
            place += upper_bound(m[i].begin(), m[i].end(), mid) 
                - m[i].begin();
        if (place < desired)
            mn = mid + 1;
        else
            mx = mid;
    }
    return mn;
    
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

        cout<<median(matrix, r, c)<<endl;
    }
    return 0;
}