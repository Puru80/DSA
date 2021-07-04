#include <bits/stdc++.h>
using namespace std;

void solution(int arr[], int n){
    bool flag=false;
    int i;
    for(i=n-1;i>=0;i--){
        if(arr[i]>arr[i-1]){
            flag = true;
            break;
        }
    }

    if(flag){
        int j;
        for(j=n-1;j>=i;j--){
            if(arr[j]>arr[i-1]){
                swap(arr[j], arr[i-1]);
                break;
            }
        }
    }
    else
        i=0;

    sort(arr+i, arr+n);
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
        
        solution(arr, n);
        for(int i=0;i<n;i++)
            cout<<arr[i]<<" ";
        cout<<endl;
    }
    return 0;
}