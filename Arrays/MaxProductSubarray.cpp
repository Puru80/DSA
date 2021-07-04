#include <bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin>>t;
    
    while(t--){
        long long n;
        cin>>n;
        long long arr[n];;
        for(int i=0;i<n;i++)
            cin>>arr[i];
        
        long long x, y, z, mx=arr[0], mn=arr[0], res=arr[0];
        
        for(int i=1;i<n;i++){
            x = arr[i];
            y = mx*x; 
            z = mn*x;
            mx = max(x, max(y, z));
            mn = min(x, min(y, z));
            res = max(res, max(mx, mn));
        }

        cout<<res<<endl;
    }
    return 0;
}   