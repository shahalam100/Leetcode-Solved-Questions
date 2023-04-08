//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {

        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.makeBeautiful(arr);
            for (int e : res) out.print(e + " ");
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> makeBeautiful(int[] arr) {
        // code here
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int num : arr){
            if(stack.empty()){
                stack.push(num);
            }else{
                if(stack.peek() >= 0 && num < 0 || stack.peek() < 0 && num >= 0){
                    stack.pop();
                }else{
                    stack.push(num);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!stack.empty()){
            list.add(stack.peek());
            stack.pop();
        }
        //Reverse the order of elements in thr list arraylist...
        Collections.reverse(list);
        
        //return the arraylist..
        return list;
    }
}
