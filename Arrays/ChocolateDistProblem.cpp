#include <bits/stdc++.h>
using namespace std;

long long findMinDiff(vector<long long> a, long long n, long long m){
    sort(a.begin(), a.end());
    long long minDif = a[a.size()-1];

    for(int i=0;i<n;i++){
        if(i+(m-1)<=n-1){
            minDif = min(minDif, a[i+(m-1)]-a[i]);
        }
    }

    return minDif;
}   

int main()
{
    long long t;
    cin>>t;
    
    while(t--){
        long long n, x, k;
        cin>>n>>k;
        vector<long long>a ;
        for(long long i=0;i<n;i++)
        {
            cin>>x;
            a.push_back(x);
        }
        
        cout<<findMinDiff(a, n, k)<<endl;
    }
    return 0;
}