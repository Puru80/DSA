package Striver;

import java.util.*;
import java.io.*;

public class PalindromeNumber{

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

    public static boolean isPalindrome(int n){
        int num = n;
        int rev = 0;
        while(n > 0){
            int a = n % 10;
            rev = rev * 10 + a;
            n = n / 10;
        }
        return num == rev;
    }

    public static void main(String[] args) throws Exception{
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int n = input.nextInt();
            pw.println(isPalindrome(n));
        }
        
        pw.flush();
    }
}
