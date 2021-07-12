package GoogleKickstart;

import java.util.*;
import java.io.*;

public class FinalExam
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

    static List<Integer> solution(List<Integer> a, int[] b){
        // Set<Integer> set = new HashSet<>();

        for(int i=0;i<b.length;i++){
            
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
            List<Integer> list = new ArrayList<>();
            int[] ar = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> 
                Integer.parseInt(s)).toArray();
            for(int i=0;i<ar[1];i++){
                int[] a = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> 
                Integer.parseInt(s)).toArray();
                list.add(a[0]);
                list.add(a[1]);
            }

            // int[] st = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> 
            // Integer.parseInt(s)).toArray();
        }
        
        pw.flush();
    }
}
