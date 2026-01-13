import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int A[] = new int[N];
            int B[] = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            int ans = 0;
            
            for(int i=0; i<N; i++){
                int a = A[i];
                for(int j=0; j<M; j++){
                    if(a <= B[j]){
                        break;
                    }
                    ans++;
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}