import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] map;
    public static StringBuilder sb;

 public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st;
     sb = new StringBuilder();
     int N = Integer.parseInt(br.readLine());

     map = new int[N];

     st = new StringTokenizer(br.readLine());
     for(int i=0; i<N; i++){
         map[i] = Integer.parseInt(st.nextToken());
     }

     int M = Integer.parseInt(br.readLine());

     for(int i=0; i<M; i++){
         st = new StringTokenizer(br.readLine());
         palindrome(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
     }

     System.out.println(sb);

 }

    private static void palindrome(int s, int e) {
     int mid = (e + s)/2;

     for(int i=s, j=e; i<=mid; i++,j--){
         if(map[i] != map[j]){
             sb.append(0).append("\n");
             return;
         }
     }
     sb.append(1).append("\n");

    }
}
