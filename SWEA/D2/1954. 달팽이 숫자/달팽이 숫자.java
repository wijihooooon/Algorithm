import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine());
        
        int[][] map;
        
        int[] dx = {0, 1, 0, -1}; // 우 하 좌 상
        int[] dy = {1, 0, -1, 0};
        
        for (int t = 1; t <= T; t++) {
            sb = new StringBuilder();
            sb.append("#").append(t).append("\n");
            
            int N = Integer.parseInt(br.readLine());
            
            map = new int[N][N];
            
            int x = 0;
            int y = 0;
            
            int dir = 0;
            int num = 1;
            
            while (num <= N * N) { // N*N까지만
                map[x][y] = num;
                num++;
                
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] != 0) {
                    dir = (dir + 1) % 4; // 방향 전환
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
                
                x = nx;
                y = ny;
            }
            
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    sb.append(map[j][k]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }
}

