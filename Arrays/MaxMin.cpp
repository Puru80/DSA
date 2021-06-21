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

struct Pair getMinMax(int arr[], int n)
{
    struct Pair minmax;
    int i;

    if(n%2==0)
    {
        if(arr[0]>arr[1])
        {
            minmax.max = arr[0];
            minmax.min = arr[1];
        }
        else
        {
            minmax.max = arr[1];
            minmax.min = arr[0];
        }

        i=2;
    }

    else
    {
        minmax.min = arr[0];
        minmax.max = arr[0];

        i=1;
    }

    while(i<n-1)
    {
        if(arr[i] > arr[i+1])
        {
            if(arr[i] > minmax.max)
                minmax.max = arr[i];
            if(arr[i+1] < minmax.min)
                minmax.min = arr[i+1];
        }
        else
        {
            if(arr[i+1] > minmax.max)
                minmax.max = arr[i+1];
            if(arr[i] < minmax.min)
                minmax.min = arr[i];
        }

        i+=2;
    }

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
    cout<<"Maximum element: "<<minmax.max<<endl;

    struct Pair m = getMinMax(arr, n);
    cout<<"Minimum element: "<<m.min<<endl;
    cout<<"Maximum element: "<<m.max;

    return 0;
}