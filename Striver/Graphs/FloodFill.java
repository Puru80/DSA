package Striver.Graphs;

import java.util.*;
import java.io.*;

public class FloodFill {

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

    static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };;

    static void dfs(int[][] image, int r, int c, int initialColor, int newColor) {
        if (image[r][c] == initialColor) {
            image[r][c] = newColor;

            for (int[] d : directions) {
                int x = r + d[0];
                int y = c + d[1];

                if (x < 0 || x >= image.length || y >= image[0].length || y < 0) {
                    continue;
                }

                dfs(image, r + d[0], c + d[1], initialColor, newColor);
            }
        }
    }

    public static int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];

        if (initialColor != color) {
            dfs(image, sr, sc, initialColor, color);
        }

        return image;
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int initialColor = image[sr][sc];

        if (image[sr][sc] == color)
            return image;

        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });

        image[sr][sc] = color;

        int x, y;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] d : directions) {
                x = cur[0] + d[0];
                y = cur[1] + d[1];

                if (x < 0 || x >= n || y >= m || y < 0) {
                    continue;
                }

                if (image[x][y] != initialColor) {
                    continue;
                }

                image[x][y] = color;
                q.add(new int[] { x, y });
            }

        }

        return image;
    }

    public static int[][] stringToInt2DArray(String str) {
        // Remove outer brackets
        str = str.substring(1, str.length() - 1);

        // Split into rows
        String[] rows = str.split("\\],\\[");

        // Initialize 2D array
        int[][] arr = new int[rows.length][];

        // Populate 2D array
        for (int i = 0; i < rows.length; i++) {
            // Remove any remaining brackets
            String row = rows[i].replaceAll("\\[|\\]", "");

            // Split into elements
            String[] elements = row.split(",");

            // Convert elements to integers
            int[] intRow = new int[elements.length];
            for (int j = 0; j < elements.length; j++) {
                intRow[j] = Integer.parseInt(elements[j].trim());
            }

            // Add row to 2D array
            arr[i] = intRow;
        }

        return arr;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String str = input.nextLine();
            int sc = input.nextInt();
            int sr = input.nextInt();
            int color = input.nextInt();

            int[][] arr = stringToInt2DArray(str);

            int[][] res = floodFillDFS(arr, sr, sc, color);
            for (int[] r : res) {
                for (int j : r) {
                    pw.print(j + " ");
                }
                pw.println();
            }
        }

        pw.flush();
    }
}