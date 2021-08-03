package Strings;

import java.util.*;
import java.io.*;

public class GetComputer
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

    public static int solution(int n, char[] arr){
        char[] visited = new char[26];

        int occupied=0, res=0;
        for(int i=0;i<arr.length;i++){
            int index = arr[i] - 'A';

            if(visited[index]==0){
                visited[index] = 1;
                if(occupied < n){
                    occupied++;
                    visited[index]=2;
                }
                else
                    res++;
            }
            else{
                if(visited[index]==2)
                    occupied--;
                visited[index] = 0;
            }
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
            int n = input.nextInt();
            char[] arr = input.nextLine().toCharArray();

            // System.out.println(n + " " + arr[0]);

            pw.println(solution(n, arr));
        }
        
        pw.flush();
    }
}
