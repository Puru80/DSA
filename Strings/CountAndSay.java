package Strings;

import java.util.*;
import java.io.*;

public class CountAndSay
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

    static String solution(int n){
        if(n==1)
            return "1";
        if(n==2)
            return "11";
        
            String str = "11";
            for (int i = 3; i <= n; i++)
            {
                // In below for loop, previous
                // character is processed in
                // current iteration. That is
                // why a dummy character is
                // added to make sure that loop
                // runs one extra iteration.
                str += '$';
                int len = str.length();
         
                int cnt = 1; // Initialize count
                             // of matching chars
                String tmp = ""; // Initialize i'th
                                 // term in series
                char []arr = str.toCharArray();
                 
                // Process previous term
                // to find the next term
                for (int j = 1; j < len; j++)
                {
                    // If current character
                    // does't match
                    if (arr[j] != arr[j - 1])
                    {
                        // Append count of
                        // str[j-1] to temp
                        tmp += cnt + 0;
         
                        // Append str[j-1]
                        tmp += arr[j - 1];
         
                        // Reset count
                        cnt = 1;
                    }
         
                    // If matches, then increment
                    // count of matching characters
                    else cnt++;
                }
         
                // Update str
                str = tmp;
            }

        return str;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int n = input.nextInt();

            pw.println(solution(n));
        }

        pw.flush();
        
    }
}