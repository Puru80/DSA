#include <bits/stdc++.h>
using namespace std;

int solution(int a, int n){

}

int main()
{
    int t;
    cin>>t;
    
    while(t--){
        int n;
        cin>>n;
        int a[n];
        for(int i=0;i<n;i++)
            cin>>a[i];

        int ans=0;
        for(int i=1;i<n;i++){
            int diff = a[i] - a[i-1];
            if(diff>0)
                ans+=diff;
        }

        cout<<ans<<endl;
    }
    return 0;
}