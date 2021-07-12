package Strings;

import java.util.*;
import java.io.*;

public class NextPermutation
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

    static List<Integer> nextPermutation(int n, int arr[]){
        // code here
        int i;
        for(i=n-1;i>0;i--)
            if(arr[i]>arr[i-1])
                break;

        if(i==0){
            Arrays.sort(arr);
            List<Integer> list = new ArrayList<>();
            for (Integer integer : arr) {
                list.add(integer);
            }
            return list;
        }
        else{
            int x = arr[i-1], min = i;
            for(int j=i+1;j<n;j++)
                if(arr[j]>x && arr[j]<arr[min])
                    min = j;

            int temp = arr[i-1];
            arr[i-1] = arr[min];
            arr[min] = temp;

            Arrays.sort(arr, i, n);
            List<Integer> list = new ArrayList<>();
            for (Integer integer : arr) {
                list.add(integer);
            }
            return list;
        }
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

            List<Integer> list = nextPermutation(n, arr);
            for(int i : list){
                pw.print(i);
            }
            pw.println();
        }
        
        pw.flush();
    }
}