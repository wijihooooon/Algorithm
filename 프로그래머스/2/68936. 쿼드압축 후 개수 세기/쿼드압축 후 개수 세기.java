import java.util.*;

class Solution {
    
    public int N;
    public int[] answer;
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        
        N = arr.length;
        
        quadTree(0, 0, N-1, N-1, arr);
        
        return answer;
    }
    
    public void quadTree(int x1, int y1, int x2, int y2, int[][] arr){
       
        // 넓이가 2*2이면 전체 순회후 같으면 같은수 +1 다르면 각수마다 +zero, +one
        if(x2-x1 == 1 && y2-y1 == 1){
            int zero = 0;
            int one = 0;
            for(int i=x1; i<=x2; i++){
                for(int j=y1; j<=y2; j++){
                    if(arr[i][j] == 0){
                        zero++;
                    }else{
                        one++;
                    }
                }
            }
            
            if(zero == 4){
                answer[0]++;
            }else if(one == 4){
                answer[1]++;
            } else{
                answer[0] += zero;
                answer[1] += one;
            }
            return;
        }
        
        // (x1,y1) ~ (x2,y2)까지 다 같은지 확인
        boolean isDifferent = false;
        int first = arr[x1][y1];
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                if(first != arr[i][j]){ // 다른게 나오면 탈주
                    isDifferent = true;
                    break;
                }
            }
            if(isDifferent) break;      // 다른게 나오면 탈주
        }
        
        if(!isDifferent){               // 전부다 같을 경우 압축 후 return
            answer[first]++;
            return;
        }
        
        // 각 사분면 재귀
        quadTree(x1, y1, (x1+x2)/2, (y1+y2)/2, arr);
        quadTree(x1, ((y1+y2)/2) + 1, (x1+x2)/2, y2, arr);
        quadTree(((x1+x2)/2)+1, y1, x2, (y1+y2)/2, arr);
        quadTree(((x1+x2)/2)+1, ((y1+y2)/2)+1, x2, y2, arr);

    }
}