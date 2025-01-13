package Arrays;

import java.util.*;
import java.io.*;

public class MooreVotingnAlgo
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

    static int isMojority(int[] arr, int n, int cand){
        int count = 0;
        for(int i=0;i<n;i++){
            if(arr[i] == cand)
                count++;
        }

        if(count > n/2)
            return cand;

        return -1;
    }

    static int getMajorityElement(int[] arr, int n) {
        int majIndex = 0, count=0;

        for(int i=0;i<n;i++){
            if(arr[majIndex] == arr[i])
                count++;
            else
                count--;
            if(count == 0){
                majIndex = i;
                count=1;
            }
        }



        return isMojority(arr, n, arr[majIndex]);
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int n = input.nextInt();
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();
            
            pw.println(getMajorityElement(arr, n));
        }
        
        pw.flush();
    }
}