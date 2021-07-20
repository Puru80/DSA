package Strings;

import java.util.*;
import java.io.*;

public class PrintAnagramsTogether
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

    static List<List<String>> solution(String[] words){
        Map<String, List<String>> map = new HashMap<>();

        for(int i=0;i<words.length;i++){
            String word = words[i];
            char[] letter = word.toCharArray();
            Arrays.sort(letter);
            String newWord = new String(letter);

            if(map.containsKey(newWord))
                map.get(newWord).add(word);
            else{
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(newWord, list);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(String s: map.keySet()){
            List<String> list = map.get(s);
            if(list.size()>=1)
                result.add(list);
        }
        return result;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        pw = new PrintWriter(new
                BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();
        
        while(t-->0){
            String arr[] = input.nextLine().split(" ");

            List<List<String>> result = solution(arr);
            for(int i=0;i<result.size();i++){
                for(int j=0;j<result.get(i).size();j++)
                    pw.print(result.get(i).get(j) + " ");
                pw.println();
            }
        }
        
        pw.flush();
    }
}
