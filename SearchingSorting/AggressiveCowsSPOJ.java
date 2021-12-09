package SearchingSorting;

import java.util.*;
import java.io.*;

public class AggressiveCowsSPOJ
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

    static int check(int arr[], int n, int c){
        int cows=1, pos=arr[0];
        for (int i=1; i<arr.length; i++)
        {
            if (arr[i]-pos>=n)
            {
                pos=arr[i];
                cows++;
                if (cows==c)
                    return 1;
            }
        }
        return 0;
    }

    static int solution(int arr[], int k){
        Arrays.sort(arr);
        /* for(int i: arr)
            pw.println(i); */

        int n = arr.length;
        int start = 0, end = arr[n-1], max=-1;

        while(end>start){
            int mid = (end+start)/2;
            if(check(arr, mid, k) == 1){
                if(mid > max)
                    max = mid;
                start = mid+1;
            }
            else end=mid;
        }

        return max;
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
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = input.nextInt();

            pw.println(solution(arr, k));
        }
        
        pw.flush();
    }
} 