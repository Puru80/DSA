#include <bits/stdc++.h>
using namespace std;

int getPairsCount(int arr[], int n, int k){
    unordered_map<int , int> map;

    for(int i=0;i<n;i++)
        map[arr[i]]++;

    int count=0;

    for(int i=0;i<n;i++){
        count+=map[k-arr[i]];

        if(k-arr[i] == arr[i])
            count--;
    }

    return count/2;
}

int main()
{
    int t;
    cin>>t;
    
    while(t--){
        int n, k;
        cin>>n>>k;
        int arr[n];
        for(int i=0;i<n;i++)
            cin>>arr[i];

        cout<<getPairsCount(arr, n, k)<<endl;
    }
    return 0;
}