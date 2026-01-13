import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(A);
            Arrays.sort(B);

            long ans = 0; 
            int j = 0;

            for (int i = 0; i < N; i++) {
                while (j < M && B[j] < A[i]) {
                    j++;
                }
                ans += j;
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
