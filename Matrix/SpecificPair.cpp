#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<int>> mat, int n){
    int maxValue = INT_MIN;
 
    // maxArr[i][j] stores max of elements in matrix
    // from (i, j) to (N-1, N-1)
    int maxArr[n][n];
 
    // last element of maxArr will be same's as of
    // the input matrix
    maxArr[n-1][n-1] = mat[n-1][n-1];

    // preprocess last row
    int maxv = mat[n-1][n-1];  // Initialize max
    for (int j = n - 2; j >= 0; j--)
    {
        if (mat[n-1][j] > maxv)
            maxv = mat[n - 1][j];
        maxArr[n-1][j] = maxv;
    }
 
    // preprocess last column
    maxv = mat[n - 1][n - 1];  // Initialize max
    for (int i = n - 2; i >= 0; i--)
    {
        if (mat[i][n - 1] > maxv)
            maxv = mat[i][n - 1];
        maxArr[i][n - 1] = maxv;
    }
 
    // preprocess rest of the matrix from bottom
    for (int i = n-2; i >= 0; i--)
    {
        for (int j = n-2; j >= 0; j--)
        {
            // Update maxValue
            if (maxArr[i+1][j+1] - mat[i][j] >
                                            maxValue)
                maxValue = maxArr[i + 1][j + 1] - mat[i][j];
 
            // set maxArr (i, j)
            maxArr[i][j] = max(mat[i][j],
                               max(maxArr[i][j + 1],
                                   maxArr[i + 1][j]) );
        }
    }
 
    return maxValue;
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
        vector<vector<int>> a(n, vector<int>(n));
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                cin>>a[i][j];

        cout<<solution(a, n);
    }
    return 0;
}