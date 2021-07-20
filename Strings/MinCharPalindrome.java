package Strings;

import java.util.*;
import java.io.*;

public class MinCharPalindrome
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

    static int[] computeLPS(String str){
        int n = str.length();
        int[] lps = new int[n];
        int i=1, len=0;
        lps[0] = 0;

        while(i<n){
            if(str.charAt(i)==str.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len!=0)
                    len = lps[len-1];
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }

    static int minCharAdded(String str){
        StringBuilder s = new StringBuilder();
        s.append(str);
        // pw.println(s.toString());

        String rev = s.reverse().toString();
        s.reverse().append("$").append(rev);

        int[] lps = computeLPS(s.toString());
        return str.length() - lps[s.length() - 1];

        // return s.toString();
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            String str = input.nextLine();
            pw.println(minCharAdded(str));
        }
        
        pw.flush();
    }
}