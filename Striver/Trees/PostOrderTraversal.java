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

public class PostOrderTraversal {

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

    //Traversal Using two stacks
    public static ArrayList<Integer> postOrderTraversalTwoStack(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.add(node);

            if (node.left != null)
                s1.push(node.left);
            if (node.right != null)
                s1.push(node.right);
        }

        while (!s2.isEmpty()) {
            res.add(s2.pop().val);
        }

        return res;
    }


    public static ArrayList<Integer> postOrderTraversalOneStack(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();



        return res;
    }

    public static void postorder(TreeNode root, ArrayList<Integer> res){
        if(root == null){
            return ;
        }

        postorder(root.left, res);
        postorder(root.right, res);

        res.add(root.val);
    }

    public static ArrayList<Integer> postOrderTraversalRec(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        postorder(root, res);

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

                if(i < n && !arr[i].equals("null")){
                    node.left = new TreeNode(Integer.parseInt(arr[i]));
                    q.add(node.left);
                }

                i++;

                if(i < n && !arr[i].equals("null")){
                    node.right = new TreeNode(Integer.parseInt(arr[i]));
                    q.add(node.right);
                }

                i++;

            }

            ArrayList<Integer> res = postOrderTraversalRec(root);
            for (int j : res) {
                pw.print(j + " ");
            }

            pw.println();
        }

        pw.flush();
    }
}