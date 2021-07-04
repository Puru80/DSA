#include <bits/stdc++.h>
using namespace std;

void multiply(vector<int> &v, int x){
    int carry=0;

    for(int i=0;i<v.size();++i){
        int prod = v[i]*x + carry;
        v[i] = prod%10;
        carry=prod/10;
    }

    while(carry){
        v.push_back(carry%10) ;
        carry/=10;
    }
}

vector<int> fact(int n){
    vector<int> v;
    v.push_back(1);

    int v_size=1;
    for(int i=1;i<n;i++)
        multiply(v, i);

    reverse(v.begin(), v.end());
    return v;
}

int main()
{
    int t;
    cin>>t;
    
    while(t--){
        int n;
        cin>>n;

        vector<int> res = fact(n);
        for(int i=0;i<res.size();i++)
            cout<<res[i];
    }
    return 0;
}