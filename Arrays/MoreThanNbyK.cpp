#include <bits/stdc++.h>
using namespace std;

void solution(int arr[], int n, int k){
    unordered_map<int , int> freq;
    int x = n / k;

    for(int i=0;i<n;i++)
        freq[arr[i]]++;

    for(auto i: freq){
        if(i.second > x)
            cout<<i.first<<" ";
    }
}

int main()
{
    int t;
    cin>>t;
    
    while(t--){
        int n, k;
        cin>>n>>k;
        int arr[n]       ;
        for(int i=0;i<n;i++)
            cin>>arr[i];

        solution(arr, n, k);
        cout<<endl;
    }
    return 0;
}