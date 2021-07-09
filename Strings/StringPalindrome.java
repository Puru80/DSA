package Strings;

import java.util.*;
import java.io.*;

public class StringPalindrome
{
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

    static int isPalindrome(String s) {
        int left=0, right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right))
                return 0;
            left++; 
            right--;
        }
        return 1;
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        FastReader input = new FastReader();
        int t = input.nextInt();
        
        while(t-->0){
            String s = input.nextLine();

            System.out.println(isPalindrome(s));

        }
        
    }
}