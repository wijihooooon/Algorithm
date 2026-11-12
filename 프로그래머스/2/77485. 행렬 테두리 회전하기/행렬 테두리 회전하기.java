import java.util.*;

class Solution {
    
    public int map[][];
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        map = new int[rows+1][columns+1];
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j] = map[i-1][columns] + j;
            }
        }
        
        for(int i=0; i<queries.length; i++){
            answer[i] = rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
        
        return answer;
    }
    
    public int rotate(int x1, int y1, int x2, int y2){
        int min = Integer.MAX_VALUE;
        
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(map[x1][y1]);
        
        // 우
        for(int i=y1+1; i<=y2; i++){
            dq.add(map[x1][i]);
            map[x1][i] = dq.poll();            
            min = Math.min(min, map[x1][i]);
        }
        // 하
        for(int i=x1+1; i<=x2; i++){
            dq.add(map[i][y2]);
            map[i][y2] = dq.poll();
            min = Math.min(min, map[i][y2]);
        }
        // 좌
        for(int i=y2-1; i>=y1; i--){
            dq.add(map[x2][i]);
            map[x2][i] = dq.poll();
            min = Math.min(min, map[x2][i]);
        }
        // 상
        for(int i=x2-1; i>=x1; i--){
            dq.add(map[i][y1]);
            map[i][y1] = dq.poll();
            min = Math.min(min, map[i][y1]);
        }
        
        return min;
    }
}