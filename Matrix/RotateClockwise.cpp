#include <bits/stdc++.h>
using namespace std;

void solution(vector<vector<int>> a, int n){
    for(int i=0;i<n;i++)
        for(int j=0;j<i;j++){
            int temp = a[i][j];
            a[i][j] = a[j][i];
            a[j][i] = temp;
        }

    for(int i=0;i<n;i++)
        for(int j=0;j<n/2;j++){
            int temp = a[i][j];
            a[i][j] = a[i][n-j-1];
            a[i][n-j-1] = temp;
        }

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cout<<a[i][j]<<" ";
        }
        cout<<endl;
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
        int n;
        cin>>n;
        vector< vector<int> > arr(n,vector<int>(n));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin>>arr[i][j];
            }
        }
        
        solution(arr, n);
    }
    return 0;
}