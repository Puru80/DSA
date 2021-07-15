package Strings;

import java.util.*;
import java.io.*;

public class SecondMostRep
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

    static String secFrequent(String arr[], int N){
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i<N;i++){
            if(map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i])+1);
            else
                map.put(arr[i], 1);
        }

        int firstMax = Integer.MIN_VALUE, secMax = Integer.MIN_VALUE;

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            int v = entry.getValue();
            if(v>firstMax){
                secMax = firstMax;
                firstMax = v;
            }
            else if (v > secMax &&
                     v != firstMax)
                secMax = v;
        }
        
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            int v = entry.getValue();
            if(v==secMax){
                return entry.getKey();
            }
        }

        return null;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            String[] arr = input.nextLine().split(" ");
            pw.println(secFrequent(arr, arr.length));
        }
        
        pw.flush();
    }
}
