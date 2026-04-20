import java.util.*;

class Solution {
    
    public int N, M;
    public int map[][];
    public ArrayList<Integer> list = new ArrayList<>();
    
    public int dx[] = {-1, 1, 0, 0};
    public int dy[] = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        int[] answer;
        
        N = maps.length;
        M = maps[0].length();
        map = new int[N][M];
        
        for(int i=0; i<N; i++){
            String str = maps[i];
            for(int j=0; j<M; j++){
                if(str.charAt(j) == 'X'){
                    map[i][j] = -1;
                }else{
                    map[i][j] = str.charAt(j) - '0';
                }
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != -1){
                    calIslandSize(i, j);
                }
            }
        }
        if(list.isEmpty()){
            return new int[] {-1};
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);    
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    public void calIslandSize(int x, int y){
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[] {x, y});
        int sum = map[x][y];
        map[x][y] = -1;
        
        while(!dq.isEmpty()){
            x = dq.peek()[0];
            y = dq.peek()[1];
            dq.pollFirst();
            
            for(int i=0; i<4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];
                
                if(cx<0 || cy<0 || cx>=N || cy>=M) continue;
                if(map[cx][cy] == -1) continue;
                
                sum += map[cx][cy];
                map[cx][cy] = -1;
                dq.offerLast(new int[] {cx, cy});
            }
        }
        list.add(sum);
    }
}