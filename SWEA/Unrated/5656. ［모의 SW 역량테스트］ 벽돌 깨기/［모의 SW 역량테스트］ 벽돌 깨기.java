import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static int N, W , H, ans;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            ans = Integer.MAX_VALUE;

            int[][] map = new int[H][W];

            for(int i=0; i<H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            brickOut(0, map);
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void brickOut(int cnt, int[][] map) {
        if(cnt == N){
            //남은 벽돌 계산해서 최소값만 남기기
            int count = 0;

            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(map[i][j] != 0) count++;
                }
            }
            ans = Math.min(ans, count);
            return;
        }

        for(int i=0; i<W; i++){
        	//배열복사
            int[][] copyMap = new int[H][W];
            for(int j=0; j<H; j++){
                System.arraycopy(map[j], 0, copyMap[j], 0, W);
            }
            // 벽돌 부수기
            crash(copyMap, i);
            // 뿌시래기 밑으로 당기기
            down(copyMap);
            // 부순거 넘기기
            brickOut(cnt+1, copyMap);
        }
    }

    private static void down(int[][] map) {
        for(int i=0; i<W; i++){
        	int index = H-1;
            for(int j=H-1; j>=0; j--){
                if(map[j][i] != 0) {
                	map[index][i] = map[j][i];
                	if(index != j) map[j][i] = 0;
                	index--;
                }
            }
        }
    }

    private static void crash(int[][] map, int where) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[H][W];
        // 시작점 찾기
        for (int i = 0; i < H; i++) {
            if (map[i][where] != 0) {
                q.offer(new int[]{i, where, map[i][where]-1});
                map[i][where] = 0;
                visited[i][where] = true;
                break;
            }
        }

        while(!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.peek()[1];
            int power = q.peek()[2];
            q.poll();

            for(int j=0; j<4; j++){
                int cx = x;
                int cy = y;
                for(int k=0; k<power; k++){
                    cx += dx[j];
                    cy += dy[j];
                    if(cx<0 || cy<0 || cx>=H || cy>=W || visited[cx][cy] || map[cx][cy] == 0) continue;
                    int cp = map[cx][cy];
                    map[cx][cy] = 0;
                    visited[cx][cy] = true;
                    if(cp == 1) continue;
                    q.offer(new int[]{cx, cy, cp-1});
                }
            }
        }
    }
}