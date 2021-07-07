#include <bits/stdc++.h>
using namespace std;

int rowWithMax1s(vector<vector<int> > arr, int n, int m) {
	int i=0, j=m-1, ans=-1;
    while(i<n && j>=0){
        if(arr[i][j]==1){
            ans = i;
            j--;
        }
        else
            i++;
    }

    return ans;
}

int main()
{
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif

    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector< vector<int> > arr(n,vector<int>(m));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin>>arr[i][j];
            }
        }

        auto ans = rowWithMax1s(arr, n, m);
        cout << ans << "\n";
    }
    return 0;
}