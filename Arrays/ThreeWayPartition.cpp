#include <bits/stdc++.h>
using namespace std;

void threeWayPartition(int arr[], int n, int a, int b){
    int l=0;
    int r = n-1;
    for(int i=0;i<=r;i++){
        if(arr[i]<a){
            swap(arr[i], arr[l]);
            l++;
        }
        else if(arr[i]>b){
            swap(arr[i], arr[r]);
            r--;
            i--;
        }
    }
}

int main()
{
    int t;
    cin>>t;
    
    while(t--){
        int n, k1, k2;
        cin>>n>>k1>>k2;
        int arr[n];
        for(int i=0;i<n;i++)
            cin>>arr[i];

        threeWayPartition(arr, n, k1, k2);
        for(int i=0;i<n;i++)
            cout<<arr[i]<<" ";
        cout<<endl;
    }
    return 0;
}