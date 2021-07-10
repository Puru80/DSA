package Strings;

import java.util.*;
import java.io.*;

public class LongestPalindromeSubstring
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

    static String longestPalin(String str){
        // code here
        int maxLen = 1;

        int start = 0;
        int len = str.length();

        int lo, hi;
        for(int i=1;i<len;++i){
            lo=i-1;
            hi=i;
            while(lo>=0 && hi<len && str.charAt(lo)==str.charAt(hi)){
                if(hi - lo + 1 > maxLen){
                    start = lo;
                    maxLen = hi - lo +1;
                }
                --lo;
                ++hi;
            }

            hi = i+1;
            lo = i-1;
            while(lo>=0 && hi<len && str.charAt(lo) == str.charAt(hi)){
                if(hi - lo + 1 > maxLen){
                    start = lo;
                    maxLen = hi - lo +1;
                }
                --lo;
                ++hi;
            }
        }
        return str.substring(start, start + maxLen); 
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            String str = input.nextLine();
            pw.println(longestPalin(str));
        }

        pw.flush();
        
    }
}