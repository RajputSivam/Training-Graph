import java.io.*;
import java.util.*;

public class Main {

    // ---------- FAST INPUT ----------
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    // ---------- MAIN ----------
    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        // ===== INPUT SECTION (EDIT AS PER PROBLEM) =====
        int t = 1;
        // t = fs.nextInt();   // uncomment if multiple test cases

        while (t-- > 0) {

            int n = fs.nextInt();    // example input
            int m = fs.nextInt();    // example input

            // ===== YOUR LOGIC STARTS HERE 👇 =====

            int ans = n + m;

            // ===== YOUR LOGIC ENDS HERE ☝️ =====

            out.append(ans).append('\n');
        }

        // ---------- OUTPUT ----------
        System.out.print(out.toString());
    }
}
