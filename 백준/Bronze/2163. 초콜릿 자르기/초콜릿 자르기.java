import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int large = Math.max(A, B);
        int small = Math.min(A, B);

        int ans = (small - 1) + ((large - 1) * small);

        System.out.println(ans);
    }
}