#include <bits/stdc++.h>
using namespace std;

int solution(int arr[], int n){
    unordered_set<int> res;
    int ans=0;

    for(int i=0;i<n;i++)
        res.insert(arr[i]);

    for(int i=0;i<n;i++){
        if(res.find(arr[i]-1) == res.end()){

            int j=arr[i];
            while(res.find(j) != res.end())
                j++;
            
            ans = max(ans, j-arr[i]);
        }
    }

    return ans;
}

int main()
{
    int t;
    cin>>t;
    
    while(t--){
        int n;
        cin>>n;
        int arr[n];
        for(int i=0;i<n;i++)
            cin>>arr[i];

        cout<<solution(arr, n);
        
    }
    return 0;
}