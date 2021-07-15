package Strings;

import java.util.*;
import java.io.*;

public class LongestCommonSubseq
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

    static int lcs(int x, int y, String s1, String s2){
        // your code here
        int L[][] = new int[x+1][y+1];

        /* Following steps build L[m+1][n+1] in bottom up fashion. Note
             that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i=0; i<=x; i++)
        {
          for (int j=0; j<=y; j++)
          {
            if (i == 0 || j == 0)
                L[i][j] = 0;
            else if (s1.charAt(i-1) == s2.charAt(j-1))
                L[i][j] = L[i-1][j-1] + 1;
            else
                L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
          }
        }
        return L[x][y];
    
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int p=input.nextInt();            
		    int q=input.nextInt();
		    
		    String s1=input.next();         
	        String s2=input.next();

            pw.println(lcs(p, q, s1, s2));
        }
        
        pw.flush();
    }
}
