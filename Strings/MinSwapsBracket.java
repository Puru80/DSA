package Strings;

import java.util.*;
import java.io.*;

public class MinSwapsBracket
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

    static int minimumNumberOfSwaps(String S){
        // code here
        int countLeft=0, countRight=0;
        int swap=0, imbalance=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='['){
                countLeft++;
                if(imbalance>0){
                    swap+=imbalance;
                    imbalance--;
                }
            }
            else if(S.charAt(i)==']'){
                countRight++;
                imbalance = countRight-countLeft;
            }
        }
        return swap;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            String str = input.nextLine();
            pw.println(minimumNumberOfSwaps(str));
        }
        
        pw.flush();
    }
}
