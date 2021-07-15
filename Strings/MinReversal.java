package Strings;

import java.util.*;
import java.io.*;

public class MinReversal
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

    static int countRev (String s){
        // your code here 
        int len = s.length();

        if(len%2!=0)
            return -1;
        
        int left =0, right = 0;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);

            if(ch == '{')
                left++;
            else{
                if(left==0)
                    right++;
                else
                    left--;
            }
        }

        return (int)(Math.ceil((0.0 + left) / 2)
            + Math.ceil((0.0 + right) / 2));
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            String s = input.nextLine();
            pw.println(countRev(s));
        }
        
        pw.flush();
    }
}