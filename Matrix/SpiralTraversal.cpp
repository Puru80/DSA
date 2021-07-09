#include <bits/stdc++.h>
using namespace std;

vector<int> spirallyTraverse(vector<vector<int> > matrix, 
                                    int r, int c) 
{
    // code here 
    vector<int>a;
    
    int top=0, down=r-1, left=0, right=c-1;
    int dir=0;

    while(top<=down && left<=right){
        if(dir==0){
            for(int i=left; i<=right;i++)
                a.push_back(matrix[top][i]);
            top++;
        }
        else if(dir==1){
            for(int i=top;i<=down;i++)
                a.push_back(matrix[i][right]);
            right--;
        }
        else if(dir==2){
            for(int i=right;i>=left;i--)
                a.push_back(matrix[down][i]);
            down--;
        }
        else{
            for(int i=down;i>=top;i--)
                a.push_back(matrix[i][left]);
            left++;
        }

        dir = (dir+1)%4;
    }
    
    return a;
}

int main()
{
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif

    int t;
    cin>>t;
    
    while(t--) 
    {
        int r,c;
        cin>>r>>c;
        vector<vector<int> > matrix(r); 

        for(int i=0; i<r; i++)
        {
            matrix[i].assign(c, 0);
            for( int j=0; j<c; j++)
            {
                cin>>matrix[i][j];
            }
        }

        vector<int> result = spirallyTraverse(matrix, r, c);
        for (int i = 0; i < result.size(); ++i)
                cout<<result[i]<<" ";
        cout<<endl;
    }
    return 0;
}