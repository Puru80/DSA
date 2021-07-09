#include <bits/stdc++.h>
using namespace std;
#define MAX 1000
int mat[MAX][MAX];

int kthSmallest(int mat[MAX][MAX], int n, int k){
    if(n==0)
        return 0;
    
    int start = mat[0][0], end = mat[n-1][n-1];
    while (start<end){
        int count = 0, j;
        int mid = start + (end-start)/2;
        for(int row=0;row<n;row++){
            j=n-1;
            while(j>=0 && mat[row][j]>mid)
                j--;
            count+=(j+1);
        }

        if(count<k) 
            start = mid+1;
        else
            end = mid;
    }

    return start;
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
        int n;
        cin>>n;
    
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                cin>>mat[i][j];
        int r;
        cin>>r;
        cout<<kthSmallest(mat,n,r)<<endl;
    }
    return 0;
}