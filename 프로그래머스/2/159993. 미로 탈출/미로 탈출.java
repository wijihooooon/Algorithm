import java.util.*;

class Solution {
    
    public int N, M;
    public int map[][];
    public boolean visited[][];
    public Deque<int[]> dq = new ArrayDeque<>();
    
    public int dx[] = {-1, 1, 0, 0};
    public int dy[] = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            String str = maps[i];
            for(int j=0; j<M; j++){
                if(str.charAt(j) == 'O'){
                    map[i][j] = 0;
                }else if(str.charAt(j) == 'X'){
                    map[i][j] = 1;
                }else if(str.charAt(j) == 'S'){
                    dq.offerLast(new int[] {i, j, 0});
                    visited[i][j] = true;
                }else if(str.charAt(j) == 'L'){
                    map[i][j] = -2;
                }else if(str.charAt(j) == 'E'){
                    map[i][j] = -3;
                }
            }
        }
        
        answer = escapeTheMaze();
        if(answer == 0) {
            return -1;
        }
        return answer;
    }
    
    public int escapeTheMaze(){
        boolean open = false;
        
        while(!dq.isEmpty()){
            int x = dq.peek()[0];
            int y = dq.peek()[1];
            int cost = dq.peek()[2];
            dq.pollFirst();
            
            for(int i=0; i<4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];
                int sum = cost + 1;
                
                if(cx<0 || cy<0 || cx>=N || cy>=M) continue;
                if(map[cx][cy] > 0) continue;
                if(visited[cx][cy]) continue;
                if(map[cx][cy] == -3 && open) return sum;
                
                if(map[cx][cy] == -2){
                    visited = new boolean[N][M];
                    visited[cx][cy] = true;
                    dq = new ArrayDeque<>();
                    dq.offerLast(new int[] {cx, cy, sum});
                    open = true;
                    break;
                }
                
                visited[cx][cy] = true;
                dq.offerLast(new int[] {cx, cy, sum});
                
            }
        }
        
        return 0;
    }
}