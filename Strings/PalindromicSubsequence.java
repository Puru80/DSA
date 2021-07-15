package Strings;

import java.util.*;
import java.io.*;

public class PalindromicSubsequence
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

    static long countPS(String str){
        // Your code here
        long n = str.length();

        long[][] ans = new long[(int)n][(int)n];
        for (int i = 0; i < n; i++)
            ans[i][i] = 1;

        for(int i=2;i<=n;i++){
            for(long j=0;j<=n-i;j++){
                long k = i + j -1;
                if(str.charAt((int)j) == str.charAt((int)k))
                    ans[(int)j][(int)k] = ans[(int)j][(int)(k - 1)]
                        + ans[(int)(j + 1)][(int)k] + 1 + 1;
                else{
                    ans[(int)j][(int)k] = ans[(int)j][(int)(k - 1)]
                                    + ans[(int)(j + 1)][(int)k]
                                    - ans[(int)(j + 1)][(int)(k - 1)];
                }
            }
        }
        return ans[0][(int)(n-1)];
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            String str = input.nextLine();
            pw.println(countPS(str));
        }
        
        pw.flush();
    }
}