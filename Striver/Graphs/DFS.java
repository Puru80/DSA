package Striver.Graphs;

import java.util.*;
import java.io.*;

public class DFS {

    public static PrintWriter pw;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(
                    new FileReader("D:/VSCode/DSA/input.txt"));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static void dfs(List<List<Integer>> adj, List<Integer> res, boolean[] visited, int s){
        visited[s] = true;
        res.add(s);

        for(int i: adj.get(s)){
            if(!visited[i]){
                dfs(adj, res, visited, i);
            }
        }
    }

    public static ArrayList<Integer> dfsOfGraph(List<List<Integer>> adj) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        dfs(adj, res, new boolean[adj.size()], 0);
        return res;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int v = input.nextInt();
            int e = input.nextInt();

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                int[] arr = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                        .toArray();

                graph.get(arr[0]).add(arr[1]);
                graph.get(arr[1]).add(arr[0]);
            }

            List<Integer> res = dfsOfGraph(graph);
            for(int i: res){
                pw.print(i + " ");
            }
            pw.println();
        }

        pw.flush();
    }
}