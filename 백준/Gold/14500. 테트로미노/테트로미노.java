import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][][] map = new int[4][501][501];

        // 값 삽입
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[0][i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> q;
        int x = N;
        int y = M;
        int temp = 0;
        // map 회전
        for(int i=1; i<4; i++){
            q = new ArrayDeque<>();
            for(int j=0; j<x; j++){
                for(int k=0; k<y; k++){
                    q.add(map[i-1][j][k]);
                }
            }
            temp = x;
            x = y;
            y = temp;
            for(int j=y-1; j>=0; j--){
                for(int k=0; k<x; k++){
                    map[i][k][j] = q.poll();
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int sum1 = 0;
        int sum2 = 0;

        // 테트로미노 전부 비교
        for(int i=0; i<4; i++){
            if(i%2==0){
                x = N;
                y = M;
            }else{
                x = M;
                y = N;
            }
            // ㅡ
            for(int j=0; j<x; j++){
                for(int k=0; k<=y-4; k++){
                    sum1 = map[i][j][k] + map[i][j][k+1] + map[i][j][k+2] + map[i][j][k+3];
                    max = Math.max(max, sum1);
                }
            }
            // L
            for(int j=0; j<=x-3; j++){
                for(int k=0; k<=y-2; k++){
                    sum1 = map[i][j][k] + map[i][j+1][k] + map[i][j+2][k] + map[i][j+2][k+1];
                    sum2 = map[i][j][k+1] + map[i][j+1][k+1] + map[i][j+2][k] + map[i][j+2][k+1];
                    max = Math.max(max, Math.max(sum1, sum2));
                }
            }
            // N
            for(int j=0; j<=x-3; j++){
                for(int k=0; k<=y-2; k++){
                    sum1 = map[i][j][k] + map[i][j+1][k] + map[i][j+1][k+1] + map[i][j+2][k+1];
                    sum2 = map[i][j][k+1] + map[i][j+1][k] + map[i][j+1][k+1] + map[i][j+2][k];
                    max = Math.max(max, Math.max(sum1, sum2));
                }
            }
            // ㅜ
            for(int j=0; j<=x-2; j++){
                for(int k=0; k<=y-3; k++){
                    sum1 = map[i][j][k] + map[i][j][k+1] + map[i][j][k+2] + map[i][j+1][k+1];
                    sum2 = map[i][j+1][k] + map[i][j+1][k+1] + map[i][j+1][k+2] + map[i][j][k+2];
                    max = Math.max(max, Math.max(sum1, sum2));
                }
            }
            // ㅁ
            for(int j=0; j<=x-2; j++){
                for(int k=0; k<=y-2; k++){
                    sum1 = map[i][j][k] + map[i][j+1][k] + map[i][j][k+1] + map[i][j+1][k+1];
                    max = Math.max(max, sum1);
                }
            }
        }
        System.out.println(max);
    }
}