#include <bits/stdc++.h>
using namespace std;

int PalinArray(int a[], int n){
    int j = n-1, i=0, ans=0;
    while(i<=j){
        if(a[i]==a[j]){
            i++;
            j--;
        }
        else if(a[i]>a[j]){
            j--;
            a[j] += a[j+1];
            ans++;
        }
        else{
            i++;
            a[i] += a[i-1];
            ans++;
        }
    }

    return ans;
}

/* void IO(){
    #ifndef ONLINE_JUDGE
  
    // For getting input from input.txt file
    freopen("input.txt", "r", stdin);
  
    // Printing the Output to output.txt file
    freopen("output.txt", "w", stdout);
  
    #endif
}
 */
int main()
{
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif

    int t;
    cin>>t;
    
    while(t--){
        int n;
        cin>>n;
        int arr[n];
        for(int i=0;i<n;i++)
            cin>>arr[i];

        cout<<PalinArray(arr, n)<<endl;
    }
    return 0;
}