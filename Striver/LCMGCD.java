package Striver;

import java.util.*;
import java.io.*;

public class LCMGCD{

    public static PrintWriter pw ;

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
     
        public FastReader() throws FileNotFoundException{
            br = new BufferedReader(
                new FileReader("D:/VSCode/DSA/input.txt"));
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

    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

    public static int[] lcmAndGcd(int a, int b) {
        // code here
        int gcd = gcd(a,b);
        int lcm = (a*b)/gcd;

        return new int[]{lcm,gcd};
    }

    public static void main(String[] args) throws Exception{
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();

            int[] res = lcmAndGcd(arr[0],arr[1]);
            pw.println("LCM: " + res[0]+"; GCD: "+res[1]);
        }
        
        pw.flush();
    }
}
