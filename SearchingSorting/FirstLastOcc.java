package SearchingSorting;

import java.util.*;
import java.io.*;

public class FirstLastOcc
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

    static ArrayList<Long> find(long arr[], int n, int x){
        ArrayList<Long> ans = new ArrayList<>();
        int lo=0, hi=n-1;
        long res=-1;
        while(lo<=hi){
            int mid = (lo + hi)/2;
            if(arr[mid] > x)
                hi = mid-1;
            else if(arr[mid] < x)
                lo = mid+1;
            else{
                res = mid;
                hi = mid-1;
            }
        }
        ans.add(res);

        lo=0;
        hi=n-1;
        res=-1;
        while(lo<=hi){
            int mid = (lo + hi)/2;
            if(arr[mid] > x)
                hi = mid-1;
            else if(arr[mid] < x)
                lo = mid+1;
            else{
                res = mid;
                lo = mid+1;
            }
        }
        ans.add(res);
        return ans;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            long arr[] = Arrays.stream(input.nextLine().split(" ")).mapToLong(s -> 
                Long.parseLong(s)).toArray();
            int x = input.nextInt();

            ArrayList<Long> ans = new ArrayList<>();
            ans = find(arr, arr.length, x);
            pw.println(ans.get(0) + " " + ans.get(1));
        }
        
        pw.flush();
    }
}