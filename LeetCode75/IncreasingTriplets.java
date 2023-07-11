package LeetCode75;

import java.util.*;
import java.io.*;

public class IncreasingTriplets{

    public static PrintWriter pw ;

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
     
        public FastReader() throws FileNotFoundException{
            br = new BufferedReader(
                new FileReader("../DSA/input.txt"));
        }
     
        String next(){
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
     
        double nextDouble(){ return Double.parseDouble(next()); }
     
        String nextLine(){
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

    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;

        if(n < 3)
            return false;

        for(int i=1;i<n-1;i++){
            if(nums[i-1] < nums[i] && nums[i] < nums[i+1])
                return true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception{
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("../DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int[] nums = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();

            pw.println(increasingTriplet(nums));
        }
        
        pw.flush();
    }
}