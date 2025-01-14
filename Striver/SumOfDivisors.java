package Striver;

import java.util.*;
import java.io.*;

public class SumOfDivisors{

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

    public static int getSumOfDivisors(int n){
        int sum = 0;

        for(int i=1;i<=n;i++){
            if(n%i == 0){
                sum += i;
            }
        }

        return sum;
    }

    public static int sumOfDivisors(int n) {
        // code here
        int sum = 0;

        for(int i=1;i<=n;i++){
            sum += getSumOfDivisors(i);
        }

        return sum;
    }

    public static void main(String[] args) throws Exception{
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        pw.println(sumOfDivisors(t));
        
        pw.flush();
    }
}
