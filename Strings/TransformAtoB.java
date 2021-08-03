package Strings;

import java.util.*;
import java.io.*;

public class TransformAtoB
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

    public static int minOps(String A, String B){
        if(A.length() != B.length())
            return -1;

        int i, j, res = 0;
        int count [] = new int [256];
       
        for(i = 0; i < A.length(); i++){
            count[A.charAt(i)]++;
            count[B.charAt(i)]--;
        }
         
        // Check if all counts become 0
        for(i = 0; i < 256; i++)
            if(count[i] != 0)
                return -1;
         
        i = A.length() - 1;
        j = B.length() - 1;

        while(i>=0){
            if(A.charAt(i)!=B.charAt(j))
                res++;
            else
                j--;
            i--;
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
            String A = input.nextLine();
            String B = input.nextLine();

            pw.println(minOps(A, B));
        }
        
        pw.flush();
    }
}