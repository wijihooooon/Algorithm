import java.util.*;

class Solution {
    
    public static int map[][];
    public static int max, cnt, x, y;
    
    public int[] solution(int n) {
        int[] answer;
        map = new int[n][n];
        
        max = 0;
        
        for(int i=1; i<=n; i++){
            max += i;
        }
        
        answer = new int[max];
        
        x = 0;
        y = 0;
        map[x][y] = 1;
        
        cnt = 1;
        while(cnt != max){
            // 밑으로
            goSnail(1, 0);
            // 우로
            goSnail(0, 1);
            // 좌상으로
            goSnail(-1, -1);
        }
        
        int idx = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 0) break;
                answer[idx] = map[i][j];
                idx++;
            }
        }
        
        return answer;
    }
    
    public void goSnail(int dx, int dy){
        
        while(true){
            int cx = x + dx;
            int cy = y + dy;
            
            if(cx<0 || cy<0 || cx>=map.length || cy>=map.length || map[cx][cy] != 0) break;
            
            cnt++;
            x = cx;
            y = cy;
            map[cx][cy] = cnt;
        }
    }
}