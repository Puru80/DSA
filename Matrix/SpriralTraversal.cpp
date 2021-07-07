#include <bits/stdc++.h>
using namespace std;

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
        int a[n][m], i, j;
        for(i=0;i<n;i++)
            for(j=0;j<m;j++)
                cin>>a[i][j];
        
        int k=0, l=0;
        while(k<n && l<m){
            for(i=l;i<m;i++)
                cout<<a[k][i]<<" ";
            k++;

            for(i=k;i<n;i++)
                cout<<a[i][m-1]<<" ";
            m--;

            if(k<n){
                for(i=m-1;i>=l;i--)     
                    cout<<a[n-1][i]<<" ";
                m--;
            }
            if(l<m){
                for(i=n-1;i>=k;i--)
                    cout<<a[i][l]<<" ";
                l++;
            }
            
        }
        cout<<endl;
    }
    return 0;
}