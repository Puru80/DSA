package Strings;

import java.util.*;
import java.io.*;

public class SmallestWindowString
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

    static int no_of_chars = 256;

    public static String solution(String str, String pat){
        int len1 = str.length();
        int len2 = pat.length();

        if(len2>len1)
            return "";

        int hash_pat[] = new int[no_of_chars];
        int hash_str[] = new int[no_of_chars];

        for(int i=0;i<len2;i++)
            hash_pat[pat.charAt(i)]++;
        
        int start = 0, start_index = -1,
        min_len = Integer.MAX_VALUE;

        int count = 0; 
        for (int j = 0; j < len1; j++) {
          
            // Count occurrence of characters 
            // of string
            hash_str[str.charAt(j)]++;

            // If string's char matches 
            // with pattern's char
            // then increment count
            if (hash_str[str.charAt(j)]
                <= hash_pat[str.charAt(j)])
                count++;

            // If all the characters are matched
            if (count == len2) {
              
                // Try to minimize the window
                while (hash_str[str.charAt(start)]
                           > hash_pat[str.charAt(start)]
                       || hash_pat[str.charAt(start)]
                              == 0) {

                    if (hash_str[str.charAt(start)]
                        > hash_pat[str.charAt(start)])
                        hash_str[str.charAt(start)]--;
                    start++;
                }

                // update window size
                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        // If no window found
        if (start_index == -1) {
            System.out.println("No such window exists");
            return "";
        }

        // Return substring starting 
        // from start_index
        // and length min_len
        return str.substring(start_index,
                             start_index + min_len);
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            String str = input.nextLine();
            String pat = input.nextLine();

            pw.println(solution(str, pat));
        }
        
        pw.flush();
    }
}