#include <bits/stdc++.h>
using namespace std;

void solution(int arr[], int n){
    // int negative=0, positive=1;

    int i=-1;
    for(int j=0;j<n;j++){
        if(arr[j]<0){
            i++;
            swap(arr[i], arr[j]);
        }
    }

    int pos=i+1, neg=0;

    while(pos<n && neg<pos && arr[neg]<0){
        swap(arr[neg], arr[pos]);
        pos++;
        neg+=2;
    }
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