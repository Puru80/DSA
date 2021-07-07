#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> sortedMatrix(int n, vector<vector<int>> Mat) {
    vector<int> v;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++)
            v.push_back(Mat[i][j]);
    }

    sort(v.begin(), v.end());

    int k=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++)
            Mat[i][j] = v[k++];
    }

    return Mat;
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
        int N;
        cin >> N;
        vector<vector<int>> v(N, vector<int>(N));
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) cin >> v[i][j];
        
        v = sortedMatrix(N, v);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) cout << v[i][j] << " ";
            cout << "\n";
        }
    }

    return 0;
}