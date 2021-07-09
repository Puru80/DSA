#include <bits/stdc++.h>
using namespace std;

void Solution(vector<vector<int>> a, int n, int m){
    unordered_map<int, int> mp;

    for(int i=0;i<m;i++)
        mp[a[0][i]] = 1;
    
    for(int i=1;i<n;i++){
        for(int j=0;j<m;j++){
            if(mp[a[i][j]]==i){
                mp[a[i][j]] = i+1;
                if(i==n-1 && mp[a[i][j]]==n)
                    cout<<a[i][j]<<" ";
            }
        }
    }

}

int main()
{
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif

    int t;
    cin>>t;
    
    while(t--){
        int n, m;
        cin>>n>>m;
        vector<vector<int>> a(n, vector<int>(m));
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                cin>>a[i][j];

        Solution(a, n, m);
        cout<<endl;
    }
    return 0;
}