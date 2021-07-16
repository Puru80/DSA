package Strings;

import java.util.*;
import java.io.*;

public class SmallestWindow
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

    public static String findSubString( String str) {
        // Your code goes here
        int max_chars = 256;
        int n = str.length();
        if(n<=1)
            return str;

        int dist_count = 0;

        boolean[] visited = new boolean[max_chars];
        Arrays.fill(visited, false);
        for(int i=0;i<n;i++)
            if(visited[str.charAt(i)] == false){
                visited[str.charAt(i)] = true;
                dist_count++;
            }

        int start = 0, start_index = -1;
        int min_len = Integer.MAX_VALUE;

        int count =0;
        int curr_count[] = new int[max_chars];
        for(int j=0;j<n;j++){
            curr_count[str.charAt(j)]++;

            if(curr_count[str.charAt(j)]==1)
                count++;

            if(count==dist_count){
                while(curr_count[str.charAt(start)]>1){
                    if(curr_count[str.charAt(start)] > 1)
                        curr_count[str.charAt(start)]--;
                    start++;
                }

                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }
        
        return str.substring(start_index, start_index + min_len);
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            String str = input.nextLine();
            pw.println(findSubString(str));
        }
        
        pw.flush();
    }
}