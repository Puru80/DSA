package SearchingSorting;

import java.util.*;
import java.io.*;

public class MooreVotingMethod
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

    static int majorityElement(int a[], int n){
        int maj_index = 0, count=1;
        for(int i=0;i<n;i++){
            if(a[maj_index] == a[i])
                count++;
            else
                count--;
            if(count==0){
                maj_index=i;
                count=1;
            }
        }
        count=0;
        for(int i=0;i<n;i++){
            if(a[i]==a[maj_index])
                count++;
        }
        if(count > n/2)
            return a[maj_index];
        return -1;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int size = input.nextInt();
            int a[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                .toArray();

            pw.println(majorityElement(a, size));
        }
        
        pw.flush();
    }
}
