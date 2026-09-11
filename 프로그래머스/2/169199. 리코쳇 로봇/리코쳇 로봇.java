import java.util.*;

class Solution {
    
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1 ,0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int N;
    public static int M;
    
    public int solution(String[] board) {
        int answer = 0;
        N = board.length;
        M = board[0].length();
        map = new char[N][M];
        visited = new boolean[N][M];
        
        int startX = 0;
        int startY = 0;
        
        for(int i=0; i<N; i++){
            String str = board[i];
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R'){
                    startX = i;
                    startY = j;
                }
            }
        }
        
        answer = bfs(startX, startY);
        
        return answer;
    }
    
    public int bfs(int startX, int startY){
        int x = startX;
        int y = startY;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.addFirst(new int[] {x, y, 0});
        visited[x][y] = true;
        while(!dq.isEmpty()){
            int[] cur = dq.pollFirst();
            x = cur[0];
            y = cur[1];
            int cnt = cur[2];
            
            for(int i=0; i<4; i++){
                int cx = x;
                int cy = y;
                while(true){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    
                    if(nx<0 || ny<0 || nx>=N || ny>=M) break;
                    if(map[nx][ny] == 'D') break;
                    
                    cx = nx;
                    cy = ny;
                }
                
                if(visited[cx][cy]) continue;
                if(map[cx][cy] == 'G') return cnt + 1;
                visited[cx][cy] = true;
                dq.addLast(new int[] {cx, cy, cnt+1});
            }
        }
        return -1;
    }
}