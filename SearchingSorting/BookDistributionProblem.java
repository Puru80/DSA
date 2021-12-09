package SearchingSorting;

import java.util.*;
import java.io.*;

public class BookDistributionProblem
{
    public static PrintWriter pw ;

    static class FastReader  
    {
        BufferedReader br;
        StringTokenizer st;
     
        public FastReader() throws FileNotFoundException
        {
            br = new BufferedReader(
                new FileReader("D:/VSCode/DSA/input.txt"));
        }
     
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
     
        int nextInt() { return Integer.parseInt(next()); }
     
        long nextLong() { return Long.parseLong(next()); }
     
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
     
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static boolean isPossible(int arr[], int n, int m, int curr_min)
    {
        int studentsRequired = 1;
        int curr_sum = 0;
     
        // iterate over all books
        for (int i = 0; i < n; i++)
        {
            // check if current number of pages are greater
            // than curr_min that means we will get the result
            // after mid no. of pages
            if (arr[i] > curr_min)
                return false;
     
            // count how many students are required
            // to distribute curr_min pages
            if (curr_sum + arr[i] > curr_min)
            {
                // increment student count
                studentsRequired++;
     
                // update curr_sum
                curr_sum = arr[i];
     
                // if students required becomes greater
                // than given no. of students,return false
                if (studentsRequired > m)
                    return false;
            }
     
            // else update curr_sum
            else
                curr_sum += arr[i];
        }
        return true;
    }

    public static int findPages(int[] arr,int n,int m)
    {
        long sum = 0 ;
        int result=0;

        if(n<m)
            return -1;

        for(int i=0;i<n;i++)
            sum+=arr[i];

        int start = 0, end = (int)sum;
        while(start <= end){
            int mid = (end+start)/2;
            if(isPossible(arr, n, m, mid)){
                result = mid;
                end = mid-1;
            }
            else 
                start = mid+1;
        }

        return result;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int n = input.nextInt();
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();
            int m = input.nextInt();

            pw.println(findPages(arr, n, m));
        }
        
        pw.flush();
    }
}