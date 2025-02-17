package Striver.Graphs;

import java.util.*;
import java.io.*;

public class BFS {

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

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[V];

        q.add(0);
        visited[0] = 1;

        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for (int i : adj.get(node)) {
                if (visited[i] != 1) {
                    visited[i] = 1;
                    q.add(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int v = input.nextInt();
            int e = input.nextInt();

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                int[] arr = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                        .toArray();

                graph.get(arr[0]).add(arr[1]);
                graph.get(arr[1]).add(arr[0]);
            }

            ArrayList<Integer> list = bfsOfGraph(v, graph);
            for(int i: list){
                pw.print(i + " ");
            }

            pw.println();
        }

        pw.flush();
    }
}
