import java.util.*;

class Solution {
    
    public char[][] map;
    public boolean[][] deleteMap;
    
    public int N, M, answer;
    
    public int solution(int m, int n, String[] board) {
        answer = 0;
        
        N = m;
        M = n;
        map = new char[N][M];
        
        for(int i=0; i<board.length; i++){
            String str = board[i];
            for(int j=0; j<str.length(); j++){
                map[i][j] = str.charAt(j);
            }
        }
        
        
        boolean check = false;
        
        while(true){
            // 검사
            boolean isCheck = check();
            
            // 삭제 OR 탈출
            if(isCheck){
                delete();
            }else{
                break;
            }
            
            // 중력
            down();
        }
        
        return answer;
    }
    
    public boolean check(){
        deleteMap = new boolean[N][M];
        boolean isdelete = false;
        
        for(int i=0; i<N-1; i++){
            for(int j=0; j<M-1; j++){
                if(map[i][j] != 'X' && map[i][j] == map[i][j+1] && map[i][j] == map[i+1][j] && map[i][j] == map[i+1][j+1]){
                    deleteMap[i][j] = true;
                    deleteMap[i][j+1] = true;
                    deleteMap[i+1][j] = true;
                    deleteMap[i+1][j+1] = true;
                    isdelete = true;
                }
            }
        }
        
        return isdelete;
    }
    
    public void delete(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(deleteMap[i][j]){
                    map[i][j] = 'X';
                    answer++;
                }
            }
        }
    }
    
    public void down(){
        for(int j=0; j<M; j++){
            for(int i=N-1; i>=0; i--){
                if(map[i][j] == 'X'){
                    for(int k=i; k>=0; k--){
                        if(map[k][j] != 'X'){
                            map[i][j] = map[k][j];
                            map[k][j] = 'X';
                            break;
                        }
                    }
                }
            }
        }
    }    
}