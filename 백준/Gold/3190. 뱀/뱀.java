import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 보드 크기
        int K = Integer.parseInt(br.readLine()); // 사과 개수

        int count = 0;
        int d = 1;

        int[][] map = new int[N+1][N+1]; // 뱀의 시작 위치가 1,1 이므로 N+1

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = -1; // 사과 = -1
        }

        int L = Integer.parseInt(br.readLine()); // 뱀 명령어 개수

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상우하좌

        Deque<snake> q = new ArrayDeque<>();
        q.add(new snake(1, 1)); // 뱀 시작 좌표
        map[1][1] = 1;

        String[] command = new String[L+1];
        int commandIdx = 0;
        for(int i=0; i<L; i++){
            command[i] = br.readLine();
        }

        while(true){
            count++;
            snake head = q.peekFirst();
            int nx = head.x + dir[d][0];
            int ny = head.y + dir[d][1];

            if (nx <= 0 || ny <= 0 || nx > N || ny > N || map[nx][ny] == 1) {
                System.out.println(count);
                return;
            }

            q.addFirst(new snake(nx, ny));
            if(map[nx][ny] != -1){
                snake tail = q.pollLast();
                map[tail.x][tail.y] = 0;
            }
            map[nx][ny] = 1;

            if(commandIdx < L){
                st = new StringTokenizer(command[commandIdx]);
                int X = Integer.parseInt(st.nextToken());
                if(count == X){
                    char C = st.nextToken().charAt(0);
                    if(C == 'D'){
                        d = (d+1)%4;
                    }else{
                        d = (d-1+4)%4;
                    }
                    commandIdx++;
                }
            }
        }

    }
    private static class snake{
        int x;
        int y;

        snake(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}