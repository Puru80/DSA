package SearchingSorting;

import java.util.*;
import java.io.*;

public class EKOSPOJ
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

    static int solution(int arr[], int n, int k){
        Arrays.sort(arr);
        // int result = 0;1

        if(arr[n-1] <= k)
            return -1;

        int start=0, end=arr[n-1];
        while(start <= end){
            int count=0;
            int mid = (end + start)/2;

            for(int i=0;i<n;i++){
                int temp = arr[i] - mid;
                count += (temp>0 ? temp:0);
            }
            if(count==k){
                end = mid;
                break;
            }
            else if ( count < k ) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
                // to have the lower bound of the cutting
                // this will be the case when this is the last
                // of the loop and Cutting from one unit above will give
                // give me smaller value.
                if ( mid > end )
                    end = mid;
            }
        }

        return end;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int n = input.nextInt();
            int k = input.nextInt();
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();

            pw.println(solution(arr, n, k));
        }
        
        pw.flush();
    }
}