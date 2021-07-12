package GoogleKickstart;

import java.util.*;
import java.io.*;

class ArithmeticSquare
{
    static Map<Integer, Integer> map = new HashMap<>();
    static PrintWriter pw;

    static class FastReader  
    {
        BufferedReader br;
        StringTokenizer st;
     
        public FastReader() throws FileNotFoundException
        {
            br = new BufferedReader(new FileReader("D:/VSCode/DSA/input.txt"));
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

    static void mapInsert(int i, int j){
        int k; //= Math.min(i, j) + Math.abs(i-j)/2;

        if(Math.abs(i-j)%2==0)
        {
            k = Math.min(i, j) + Math.abs(i-j)/2;
        
            if(map.containsKey(k))
                map.put(k, map.get(k) + 1);
            else
                map.put(k, 1);
        }
    }

    static void mapInsert(int k){
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            map.put(entry.getKey(), entry.getValue()+1);
        }
    }

    static int solution(int[][] arr){
        int k=0;
        mapInsert(arr[0][0], arr[2][2]);
        mapInsert(arr[0][2],arr[2][0]);
        mapInsert(arr[0][1],arr[2][1]);
        mapInsert(arr[1][0],arr[1][2]);

        if(Math.abs(arr[0][0]-arr[0][2])%2==0){
            k = Math.min(arr[0][0], arr[0][2]) + Math.abs(arr[0][0]-arr[0][2])/2;
            if(k==arr[0][1])
                mapInsert(k);
        }
        if(Math.abs(arr[0][0]-arr[2][0])%2==0){
            k = Math.min(arr[0][0], arr[2][0]) + Math.abs(arr[0][0]-arr[2][0])/2;
            if(k==arr[1][0])
                mapInsert(k);
        }
        if(Math.abs(arr[2][0]-arr[2][2])%2==0){
            k = Math.min(arr[2][0], arr[2][2]) + Math.abs(arr[2][0]-arr[2][2])/2;
            if(k==arr[2][1])
                mapInsert(k);
        }
        if(Math.abs(arr[2][2]-arr[0][2])%2==0){
        k = Math.min(arr[2][2], arr[0][2]) + Math.abs(arr[2][2]-arr[0][2])/2;
        if(k==arr[1][2])
            mapInsert(k);}

        Map.Entry<Integer, Integer> en = map.entrySet().iterator().next();
        k = en.getKey();
        int res=0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(map.get(k)>entry.getValue())
                res = map.get(k);
            else{
                k = entry.getKey();
                res = entry.getValue();
            }
        }
        map.clear();
        return res;
    }

    public static void main(String[] args) throws Exception
    {
        FastReader input = new FastReader();
        int t = input.nextInt();
        int test = 1;
        
        while(test<=t){
            int[][] list = new int[3][3];
            for(int i=0;i<3;i++){
                int a[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> 
                    Integer.parseInt(s)).toArray();
                if(a.length<3){
                    int temp1 = a[1];
                    int temp2 = a[0];
                    a = new int[3];
                    a[0] = temp2;
                    a[1] = 0;
                    a[2] = temp1;
                }

                list[i] = a;
            }
        
            System.out.println("Case " + "#" + test + ": " + solution(list));
            test++;

        }
    }
}
