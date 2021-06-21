#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin>>n;

    int arr[n];
    for(int i=0;i<n;i++)
        cin>>arr[i];

    int c1=0, c0=0, c2=0;
    for(int i=0;i<n;i++)
    {
        if(arr[i]==0)
            c0++;
        if(arr[i]==1)
            c1++;
        if(arr[i]==2)
            c2++;
    }
    
    int i=0;

    while(c0>0)
    {
        arr[i++] = 0;
        c0--;
    }
    while(c1>0)
    {
        arr[i++] = 1;
        c1--;
    }
    while(c2>0)
    {
        arr[i++] = 2;
        c2--;
    }

    for(int j=0;j<n;j++)
        cout<<arr[j]<<" ";

    return 0;
}