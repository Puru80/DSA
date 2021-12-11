package SearchingSorting;

import java.util.*;
import java.io.*;

public class RotiPrataSPOJ
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

    static boolean check(int arr[], int mid, int k){
        int time = 0, prata = 0;

        for(int i=0;i<arr.length;i++){
            time = arr[i];
            int j=2;
            while(time<=mid){
                prata++;
                time += (arr[i]*j);
                j++;
            }
        }

        return prata>=k;
    }

    static int solution(int arr[], int k, int max){
        int lo=0, hi = max, res=0;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(check(arr, mid, k)){
                res = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return res;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int k = input.nextInt();
            int n = input.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = input.nextInt();
            
            Arrays.sort(arr);
            
            pw.println(solution(arr, k, (int)Math.pow(10, 8)));
        }
        
        pw.flush();
    }
}