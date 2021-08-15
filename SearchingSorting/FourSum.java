package SearchingSorting;

import java.util.*;
import java.io.*;

public class FourSum
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

    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        ArrayList<ArrayList<Integer>>  res = new ArrayList<>();
        ArrayList<Integer> inter = new ArrayList<>();

        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                 int r = j+1, l = n-1;
                 while(r<l){
                    int sum = arr[i] + arr[j] + arr[l] + arr[r];
                    if(sum == k){
                        inter.add(arr[i]);
                        inter.add(arr[j]);
                        inter.add(arr[l]);
                        inter.add(arr[r]);
                        res.add(inter);
                        inter.clear();
                    }
                    else if(sum < k)
                        j++;
                    else
                        i++;
                 }
            }
        }

        return res;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                            .toArray();
            int k = input.nextInt();

            /* ArrayList<ArrayList<Integer>>  res = fourSum(arr, k);
            for(int i=0;i<res.size();i++){
                pw.println("Test case: " + (i+1));
                for(int j=0;j<res.get(i).size();j++)
                    pw.print(res.get(i).get(j) + " ");

                pw.println();
            } */

            ArrayList<ArrayList<Integer>> ans = fourSum(arr, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    pw.print(u + " ");
                }
                pw.print("$");
            }
            if (ans.isEmpty()) {
                pw.print(-1);
            }
            pw.println();
        }
        
        pw.flush();
    }
}
