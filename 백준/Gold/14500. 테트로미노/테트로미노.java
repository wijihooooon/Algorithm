import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[][] map;

    public static int[][][] type = {
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, // ㅡ
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}}, // ㅣ

            {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // ㅁ

            {{0,0},{1,0},{2,0},{2,1}},   // └
            {{0,1},{1,1},{2,1},{2,0}},   // ┘
            {{0,0},{0,1},{0,2},{1,0}},   // ┌
            {{0,0},{0,1},{0,2},{1,2}},   // ┐
            {{0,0},{1,0},{1,1},{1,2}},   // Γ (L 90°)
            {{0,2},{1,0},{1,1},{1,2}},   // _| (L 270°)
            {{0,0},{0,1},{1,0},{2,0}},   // ⎡ (L 180°)
            {{0,0},{0,1},{1,1},{2,1}},   // ⎣ (L 180° 대칭)  

            // Z (S) 계열 (4개)
            {{0,0},{0,1},{1,1},{1,2}},   // S 가로  
            {{1,0},{1,1},{0,1},{0,2}},   // Z 가로  
            {{0,1},{1,1},{1,0},{2,0}},   // S 세로  
            {{0,0},{1,0},{1,1},{2,1}},   // Z 세로  
        
            // T (ㅜ) 계열 (4개)  
            {{0,0},{0,1},{0,2},{1,1}},   // ㅜ  
            {{0,1},{1,0},{1,1},{2,1}},   // ㅏ  
            {{1,0},{1,1},{1,2},{0,1}},   // ㅗ  
            {{0,0},{1,0},{2,0},{1,1}}    // ㅓ  
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int ans = 0;

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                ans = Integer.max(cal(i, j), ans);
            }
        }

        System.out.println(ans);

    }

    public static int cal(int x, int y){
        int sum;
        int flag;
        int max = 0;
        for(int i=0; i<type.length; i++){
            sum = 0;
            flag = 0;
            for(int j=0; j<4; j++){
                if(x + type[i][j][0] < 0 || x + type[i][j][0] >= N || y + type[i][j][1] < 0 || y + type[i][j][1] >= M) break;
                sum += map[x + type[i][j][0]][y + type[i][j][1]];
                flag++;
            }
            if(flag == 4){
                max = Integer.max(sum, max);
            }
        }
        return max;
    }
}