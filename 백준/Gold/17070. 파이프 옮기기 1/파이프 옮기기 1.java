import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[][] map;
    public static int count;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        count = 0;

        map = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Move(new pipe(1, 1), new pipe(1, 2));

        System.out.println(count);

    }
    private static void Move(pipe tail, pipe head){

        if(head.x == N && head.y == N){
            count++;
            return;
        }

        if(head.x == tail.x && tail.y+1 == head.y ){ // 가로
            // 가로 췍
                if(head.y + 1 <= N && map[head.x][head.y+1] == 0){
                    Move(new pipe(head.x, head.y), new pipe(head.x, head.y+1));
                    // 대각 췍
                    if(head.x + 1 <= N && map[head.x+1][head.y+1] == 0 && map[head.x+1][head.y] == 0){
                        Move(new pipe(head.x, head.y), new pipe(head.x+1, head.y+1));
                    }
                }
        }else if(tail.x+1 == head.x && tail.y == head.y){ // 세로
            // 세로 췍
            if(head.x+1 <= N && map[head.x+1][head.y] == 0){
                Move(new pipe(head.x, head.y), new pipe(head.x+1, head.y));
                // 대각 췍
                if(head.y+1 <= N && map[head.x+1][head.y+1] == 0 && map[head.x][head.y+1] == 0){
                    Move(new pipe(head.x, head.y), new pipe(head.x+1, head.y+1));
                }
            }
        }else if(tail.x + 1 == head.x && tail.y+1 == head.y){ // 대각
            // 가로 췍
            if(head.y+1 <= N && map[head.x][head.y+1] == 0){
                Move(new pipe(head.x, head.y), new pipe(head.x, head.y+1));
            }
            // 세로 췍
            if(head.x+1 <= N && map[head.x+1][head.y] == 0){
                Move(new pipe(head.x, head.y), new pipe(head.x+1, head.y));
            }
            // 대각 췍
            if(head.x+1 <= N && head.y+1 <= N &&
                    map[head.x][head.y+1] == 0 &&
                    map[head.x+1][head.y] == 0 &&
                    map[head.x+1][head.y+1] == 0){
                Move(new pipe(head.x, head.y), new pipe(head.x+1, head.y+1));
            }
        }
    }

    private static class pipe{
        int x;
        int y;

        pipe(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}

/*
    풀이 아이디어
    재귀사용

    파이프를 tail과 head로 나눔

    현재 파이프 상태가 가로인지 세로인지 대각인지 따진 후
    이동 할 수 있는 방향으로 재귀

    종료조건
    head가 종료 n*n에 도착하면 count++하고 return

 */
