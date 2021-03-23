import java.util.Arrays;

public class CountingSort
{
    static void countSort(int[] arr)
    {
        //Finding the maximum element for the range
        int max = Arrays.stream(arr).max().getAsInt();
        //Finding the minimum element
        int min = Arrays.stream(arr).min().getAsInt();

        int range = max - min + 1;

        //Array to store the count of each element
        int count[] = new int[range];
        //Output array for the final sorted array
        int output[] = new int[arr.length];

        //Counting teh occurence of each distinct element
        for (int i = 0; i < arr.length; i++) 
        {
            count[arr[i] - min]++;
        }
 
        //Modifying count[] to store the actual position
        for (int i = 1; i < count.length; i++) 
        {
            count[i] += count[i - 1];
        }
 
        //Build the output array
        for (int i = arr.length - 1; i >= 0; i--) 
        {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        
        //Copying the output array to the original array,
        //so that the original array contains the ssorted elements
        for (int i = 0; i < arr.length; i++) 
        {
            arr[i] = output[i];
        }

        //Print the sorted array
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void main(String[] args) 
    {
        int arr[] = {1, 3, 2, -1, -6, -1, 4, 1, 6, 4, 3, 2, 4};
        countSort(arr);
    }
}