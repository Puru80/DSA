#include <bits/stdc++.h>
using namespace std;

int sb(int arr[], int n, int x)
{
    int mn = 9999, sum = 0, l=0;
    for(int i=0;i<n;i++){
        sum+=arr[i];
        while(sum>x){
            mn = min(mn, i-l+1);
            sum-=arr[l];
            l++;
        }
    }

    return mn;
}

int main()
{
    int t;
    cin>>t;
    
    while(t--){
        int n, x;
        cin>>n>>x;
        int arr[n];
        for(int i=0;i<n;i++)
            cin>>arr[i];

        cout<<sb(arr, n, x)<<endl;
    }
    return 0;
}