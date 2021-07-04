#include <bits/stdc++.h>
using namespace std;

int solution(int arr[], int n, int k){
    sort(arr, arr + n); 

    int minEle, maxEle; 
    int result = arr[n - 1] - arr[0];
 
    for (int i=1;i<n;i++) {
        if (arr[i] >= k && arr[n - 1] >= k) {
            maxEle = max(arr[i - 1] + k, arr[n - 1] - k);
            minEle = min(arr[0] + k, arr[i] - k);
 
            result = min(result, maxEle - minEle);
        }
    }
    return result;
}

int main()
{
    int t;
    cin>>t;
    
    while(t--){
        int n, k;
        cin>>k;
        cin>>n;
        int arr[n];
        for(int i=0;i<n;i++)
            cin>>arr[i];

        cout<<solution(arr, n, k)<<endl;
    }
    return 0;
}