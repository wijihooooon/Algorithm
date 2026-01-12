import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        int arr[][] = new int[N][2];
        int dp[] = new int[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = Math.max(a, b); 
            arr[i][1] = Math.min(a, b);
        }

        Arrays.sort(arr, (a, b) -> {
            int cmp = Integer.compare(b[0], a[0]);
            if (cmp != 0) return cmp;
            return Integer.compare(b[1], a[1]);
        });

        for(int i=0; i<N; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i][0] <= arr[j][0] && arr[i][1] <= arr[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}