package Strings;

import java.util.*;
import java.io.*;

public class IsomorphicStrings
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

    static boolean areIsomorphic(String str1, String str2){
        if(str1.length() != str2.length())
            return false;

        boolean[] marked = new boolean[256];
        Arrays.fill(marked, false);

        int map[] = new int[256];
        Arrays.fill(map, -1);
        for(int i=0;i<str1.length();i++){
            if(map[str1.charAt(i)] == -1){
                if(marked[str2.charAt(i)] == true)
                    return false;
                
                marked[str2.charAt(i)] = true;
                map[str1.charAt(i)] = str2.charAt(i);
            }
            else if(map[str1.charAt(i)] != str2.charAt(i))
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            String str1 = input.nextLine();
            String str2 = input.nextLine();

            pw.println(areIsomorphic(str1, str2));
        }
        
        pw.flush();
    }
}