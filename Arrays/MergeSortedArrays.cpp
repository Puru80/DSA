#include <bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin>>t;
    
    while(t--){
        int n, m;
        cin>>n>>m;
        int a[n], b[m];

        for(int i=0;i<n;i++)
            cin>>a[i];
        for(int i=0;i<m;i++)
            cin>>b[i];

        int i=n-1, j=0;
        for(; i>=0 && j<m; i--, j++){
            if(a[i]>=b[j])
                swap(a[i], b[j]);
            else
                break;
        }

        sort(a, a+n);
        sort(b, b+m);

        

    }
    return 0;
}