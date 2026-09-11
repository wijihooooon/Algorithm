import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer;
        
        int N = park.length; // 세로
        int M = park[0].length(); // 가로
        
        // 시작 지점 좌표
        int x = 0; 
        int y = 0;
        
        // 공원 지도
        int[][] map = new int[N][M];
        
        for(int i=0; i<N; i++){
            String str = park[i];
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S'){
                    x = i;
                    y = j;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++){
            String str = routes[i];
            char command = str.charAt(0);
            int move = str.charAt(2) - '0';
            
            boolean isPossible = true;
            switch(command){
                case 'N':
                    for(int j=1; j<=move; j++){
                        if(x-j < 0 || map[x-j][y] == 'X'){
                            isPossible = false;
                            break;   
                        }
                    }
                    if(isPossible) x -= move;
                    break;
                case 'S':
                    for(int j=1; j<=move; j++){
                        if(x+j >= N || map[x+j][y] == 'X'){
                            isPossible = false;
                            break;
                        }
                    }
                    if(isPossible) x += move;
                    break;
                case 'W':
                    for(int j=1; j<=move; j++){
                        if(y-j < 0 || map[x][y-j] == 'X'){
                            isPossible = false;
                            break;
                        }
                    }
                    if(isPossible) y -= move;
                    break;
                case 'E':
                    for(int j=1; j<=move; j++){
                        if(y+j >= M || map[x][y+j] == 'X'){
                            isPossible = false;
                            break;
                        }
                    }
                    if(isPossible) y += move;
                    break;
            }
        }
        answer = new int[] {x, y};
        return answer;
    }
}