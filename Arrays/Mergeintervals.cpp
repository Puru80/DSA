#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> solution(vector<vector<int>>& v){
    sort(v.begin(), v.end());

    vector<vector<int>> res;
    for(int i=0;i<v.size();i++){
        if(res.size()==0 || v[i][0]>res.back()[1])
            res.push_back(v[i]);
        else
            res.back()[1] = max(res.back()[1], v[i][0]);
    }

    return res;
}

int main()
{
    int t;
    cin>>t;
    
    while(t--){
        
    }
    return 0;
}