package SearchingSorting;

import java.util.*;
import java.io.*;

public class SmallestFactNumber
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

    static boolean check(int mid, int n) {
        int temp = mid, count=0, f=5;
        while(f<=temp){
            count += temp/f;
            f = f*5;
        }
        return (count>=n);
    }

    static int findNum(int n){
        // Complete this function
        if(n==1)
            return 5;
        
        int lo=0, hi=5*n;
        while(lo<hi){
            int mid = (lo + hi) >> 1;

            if (check(mid, n))
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int n = input.nextInt();
            pw.println(findNum(n));
        }
        
        pw.flush();
    }
}

