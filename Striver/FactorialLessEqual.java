package Striver;

import java.util.*;
import java.io.*;

public class FactorialLessEqual{

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

    static long getFactorial(long n){
        if(n<=1)
            return 1;
        
        return n * getFactorial(n-1);
    }

    static ArrayList<Long> factorialNumbers(long n) {
        // code here
        ArrayList<Long> res = new ArrayList<>();

        for (long i=1; i<=n; i++){
            long fact = getFactorial(i);
            if (fact > n)
                break;
            res.add(fact);
        }

        return res;
    }


    public static void main(String[] args) throws Exception{
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            long n = input.nextLong();
            ArrayList<Long> res = factorialNumbers(n);
            for (long i : res){
                pw.print(i + " ");
            }
            pw.println();
        }
        
        pw.flush();
    }
}