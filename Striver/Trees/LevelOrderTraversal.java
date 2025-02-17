package Striver.Trees;

import java.util.*;
import java.io.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LevelOrderTraversal {

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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) {
            return res;
        }

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();

            for(int i=0;i<size; i++){
                TreeNode node = q.poll();

                level.add(node.val);

                if(node.left != null){
                    q.add(node.left);
                } 
                if(node.right != null){
                    q.add(node.right);
                }
            }

            res.add(level);
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/DSA/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String[] arr = input.nextLine().split(" ");
            int n = arr.length;

            Queue<TreeNode> q = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            q.add(root);

            int i = 1;
            while (i < n) {

                TreeNode node = q.poll();

                if (i < n && !arr[i].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(arr[i]));
                    q.add(node.left);
                }

                i++;

                if (i < n && !arr[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(arr[i]));
                    q.add(node.right);
                }

                i++;

            }

            List<List<Integer>> res = levelOrder(root);
            for(List<Integer> list: res){
                for(int k: list){
                    pw.print(k + " ");
                }
            }

            pw.println();
        }

        pw.flush();
    }
}