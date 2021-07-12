package Strings;

import java.util.*;
import java.io.*;

public class WordBreak
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

    /* public static int wordBreak(String A, ArrayList<String> B ){
        Set<String> dictionary = new HashSet<>();
        for (String string : B) 
            dictionary.add(string);

        int size = A.length();

        if(size == 0)
            return 0;
        
        for(int i=1;i<=A.length();i++){
            if(dictionary.contains(A.substring(0,i)) && 
                dictionary.contains(A.subSequence(i, A.length())))
                    return 1;
        }
        return 0;
    } */

    public static int wordBreak(String A, ArrayList<String> B ){
        Set<String> dictionary = new HashSet<>();
        for (String string : B) 
            dictionary.add(string);

        int size = A.length();
        if(size==0)
            return 1;

        int[] arr = new int[size+1];
        for(int i=1;i<=size;i++){
            if(arr[i]==0 && dictionary.contains(A.substring(0, i))){
                arr[i]=1;
                // pw.println(i);
                // pw.println("Yes");
            }
            
            if(arr[i]==1){
                if(i==size)
                    return 1;

                for (int j = i+1; j <= size; j++)
                {
                    if (arr[j]==0 && dictionary.contains( A.substring(i, j) )){
                        arr[j] = 1;
                        // pw.println("Yes");
                    }

                    if (j == size && arr[j] == 1)
                        return 1;
                }
            }
        }

        
        return 0;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            int n = input.nextInt();
            ArrayList<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(input.next());
            }
            String a = input.nextLine();

            pw.println(wordBreak(a, list));

        }
        
        pw.flush();
    }
}
