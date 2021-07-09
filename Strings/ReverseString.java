package Strings;

import java.util.*;
import java.io.*;

public class ReverseString
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

    static void Solution(char[] s){
        int left = 0, right = s.length-1;
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

        for(int i=0;i<s.length;i++)
                System.out.print(s[i]);
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-->0){
            String s = input.nextLine();
            char[] st = s.toCharArray();
            Solution(st);
            
        }
    }
}