import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 🔹 First line: 3 numbers
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        // 🔹 Second line: single character
        String lineForChar = br.readLine();
        char ch = lineForChar.charAt(0);

        // 🔹 Third line: string
        String name = br.readLine();

        // 🔹 Printing to verify
        System.out.println("n = " + n);
        System.out.println("m = " + m);
        System.out.println("x = " + x);
        System.out.println("ch = " + ch);
        System.out.println("name = " + name);
    }
}
// Input
// 5 10 7
// A
// Shivam
// output
// n = 5
// m = 10
// x = 7
// ch = A
// name = Shivam

// 🔹 StringTokenizer kyun use karte hain?
// Simple language me:
// StringTokenizer ka use ek line ke data ko parts (tokens) me todne ke liye hota hai.

// 🔹 BufferedReader ka use kyun karte hain?
// Simple language me:
// BufferedReader fast input lene ke liye use hota hai.
