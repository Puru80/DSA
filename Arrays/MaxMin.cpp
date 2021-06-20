#include <bits/stdc++.h>
using namespace std;

struct Pair
{
    int min;
    int max;
};

//Tournament Method
struct Pair getMinMax(int arr[], int low, int hi)
{
    struct Pair minmax, mml, mmr;
    int mid;

    // If there is only one element
    if (low == hi)
    {
        minmax.max = arr[low];
        minmax.min = arr[low];    
        return minmax;
    }
     
    // If there are two elements
    if (hi == low + 1)
    {
        if (arr[low] > arr[hi])
        {
            minmax.max = arr[low];
            minmax.min = arr[hi];
        }
        else
        {
            minmax.max = arr[hi];
            minmax.min = arr[low];
        }
        return minmax;
    }

    mid = (low + hi)/2;
    mml = getMinMax(arr, low, mid);
    mmr = getMinMax(arr, mid+1, hi);

    //Compare minimums of two parts
    if(mml.min < mmr.min)
        minmax.min = mml.min;
    else
        minmax.min = mmr.min;

    //Compare maximums of two parts
    if(mml.max > mmr.max)
        minmax.max = mml.max;
    else
        minmax.max = mmr.max;

    return minmax;
}

int main()
{
    int n;
    cin>>n;

    int arr[n];
    for(int i=0;i<n;i++)
        cin>>arr[i];

    struct Pair minmax = getMinMax(arr, 0, n-1);

    cout<<"Minimum element: "<<minmax.min<<endl;
    cout<<"Maximum element: "<<minmax.max;
    
    return 0;
}