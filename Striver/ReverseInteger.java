package Striver;

import java.util.*;
import java.io.*;

public class ReverseInteger{

    public static PrintWriter pw ;

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
     
        public FastReader() throws FileNotFoundException{
            br = new BufferedReader(
                new FileReader("D:/VSCode/DSA/input.txt"));
        }
     
        String next(){
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
     
        double nextDouble(){ return Double.parseDouble(next()); }
     
        String nextLine(){
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

    public static int reverse(int x) {
        int rev = 0;
        while(x!=0){
            int pop = x%10;
            x/=10;
            if(rev>Integer.MAX_VALUE/10 || (rev==Integer.MAX_VALUE/10 && pop>7)) return 0;
            if(rev<Integer.MIN_VALUE/10 || (rev==Integer.MIN_VALUE/10 && pop<-8)) return 0;
            rev = rev*10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) throws Exception{
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int n = input.nextInt();
            pw.println(reverse(n));
        }
        
        pw.flush();
    }
}
