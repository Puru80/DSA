#include <bits/stdc++.h>
using namespace std;

vector <int> commonElements (int A[], int B[], int C[], int n1, int n2, int n3)
{
    vector<int> res;
    int i=0, j=0, k=0;
    set<int> s;

    while(i<n1 && j<n2 && k<n3){
        if(A[i]==B[j] && B[j]==C[k]){
            s.insert(A[i]);
            i++;
            k++;
            j++;
        }

        else if(A[i]<=B[j] && A[i]<=C[k])
            i++;
        else if(B[j]<=A[i] && B[j]<=C[k])
            j++;
        else if(C[k]<=B[j] && C[k]<=A[i])
            k++;
    }

    res.assign(s.begin(), s.end());
    return res;
}

int main()
{
    int t;
    cin>>t;
    
    while(t--){
        int n1, n2, n3;
        cin>>n1>>n2>>n3;
        int A[n1], B[n2], C[n3];
        for(int i=0;i<n1;i++) cin>>A[i];
        for(int i=0;i<n2;i++) cin>>B[i];
        for(int i=0;i<n3;i++) cin>>C[i];

        vector<int> v = commonElements(A, B, C, n1, n2, n3);
        for(int i=0;i<v.size();i++)
            cout<<v[i]<<" ";
        cout<<endl;
    }
    return 0;
}