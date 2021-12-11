package SearchingSorting;

import java.util.*;
import java.io.*;

public class DoubleHelixSPOJ
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

    static int solution(int a[], int b[], int n, int m){
        int ans=0;
        int i=0, j=0;
        int s1=0, s2=0;

        while(i<n && j<m){
            if(a[i] < b[j])
                s1 += a[i++];
            else if(b[j] < a[i])
                s2 += b[j++];
            else{
                ans += a[i] + Math.max(s1, s2);
                s1=s2=0;
                i++;
                j++;
            }
        }

        while(i<n)
            s1+=a[i++];
        while(j<m)
            s2+=b[j++];
        
        ans += Math.max(s1, s2);

        return ans;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int n = input.nextInt();
            int arr1[] = new int[n];
            for(int i=0;i<n;i++)
                arr1[i] = input.nextInt();
            int m = input.nextInt();
            int arr2[] = new int[n];
            for(int i=0;i<m;i++)
                arr2[i] = input.nextInt();

            pw.println(solution(arr1, arr2, n, m));
        }
        
        pw.flush();
    }
}
