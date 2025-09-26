import java.util.*;

class Solution {
    
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int[][] visited;

    public static int N, M;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M  = maps[0].length;
        
        visited = new int[N][M];
        
        bfs(0, 0, maps);
        
        if(visited[N-1][M-1] == 0) {
            return -1;
        }else{
            return visited[N-1][M-1];
        }
    }
    
    public static void bfs(int x, int y, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = 1;
        while(!q.isEmpty()){
            x = q.peek()[0];
            y = q.peek()[1];
            q.poll();
            
            for(int i=0; i<4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];
                
                if (cx < 0 || cy < 0 || cx >= N || cy >= M) continue;
                if (maps[cx][cy] == 0) continue;
                if (visited[cx][cy] != 0) continue;
                
                visited[cx][cy] = visited[x][y] + 1;
                q.add(new int[]{cx, cy});
            }
        }
        return;
    }
}