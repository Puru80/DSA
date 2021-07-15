package Strings;

import java.util.*;
import java.io.*;

public class BoyerMoore
{
    public static PrintWriter pw ;
    static int no_of_chars = 256;
    static int badChar[] = new int[no_of_chars]; 

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

    static void badCharHeuristic(char[] str, int size, int badChar[]){
        for(int i=0;i<no_of_chars;i++)
            badChar[i] = -1;

        for(int i=0;i<size;i++)
            badChar[(int)str[i]] = i;

    }

    static void search(char[] txt, char[] pat){
        int n = txt.length;
        int m = pat.length;

        badCharHeuristic(pat, m, badChar);

        int s = 0;
        while(s <= (n-m)){
            int j = m-1;

            while(j>=0 && pat[j]==txt[s+j])
                j--;

            if(j<0){
                pw.println("Pattern Occurs at index: " + s);
                s+=(s+m<n)?m-badChar[txt[s+m]]:1;
            }
            else
            s += Math.max(1, j - badChar[txt[s+j]]);

        }
    }


    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            String s1 = input.nextLine();
            String s2 = input.nextLine();

            char[] txt = s1.toCharArray();
            char[] pat = s2.toCharArray();

            search(txt, pat);

        }
        
        pw.flush();
    }
}