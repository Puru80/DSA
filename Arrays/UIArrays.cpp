#include <bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin>>t;

    while(t--){
        int n, m;
        cin >> n >> m;
        int ar1[n], ar2[m];

        unordered_map<int, int> map;

        for(int i=0;i<n;i++){
            cin>>ar1[i];
            map[ar1[i]]++;
        }
        for(int i=0;i<m;i++){
            cin>>ar2[i];    

            map[ar2[i]]++;
        }

        cout<<map.size()<<" "<<n+m-map.size()<<endl;
    }
    
    return 0;
}