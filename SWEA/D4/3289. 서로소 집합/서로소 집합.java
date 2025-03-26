import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    private static int[] arr;
    private static int[] rank;
     
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for(int t=1; t<=T; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
             
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
             
            arr = new int[N+1];         
            rank = new int[N+1];
             
            for(int i=1; i<=N; i++) {
                arr[i] = i;
            }
             
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                 
                int command = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                 
                if(command == 0) {
                    union(x, y);
                }else {
                    if(find(x) == find(y)) {
                        sb.append(1);
                    }else {
                        sb.append(0);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
 
    private static int find(int x) {
        if(arr[x] != x) arr[x] = find(arr[x]);
        return arr[x];
    }
 
    private static void union(int x, int y) {
        int nx = find(x);
        int ny = find(y);
         
        if(nx == ny) return;
         
        if(rank[nx] < rank[ny]) {
            arr[nx] = ny;
        }else if(rank[ny] < rank[nx]) {
            arr[ny] = nx;
        }else {
            arr[ny] = nx;
            rank[nx]++;
        }   
    }
}