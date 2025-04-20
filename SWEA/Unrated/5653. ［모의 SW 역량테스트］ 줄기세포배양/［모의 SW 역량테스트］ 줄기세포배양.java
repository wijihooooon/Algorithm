import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static int[] dx ={-1, 1, 0, 0};
    public static int[] dy ={0, 0, -1, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st. nextToken());

            Cell[][] map = new Cell[1000][1000];

            Queue<Cell> deadCells = new ArrayDeque<>();
            Queue<Cell> inactiveCells = new ArrayDeque<>();
            PriorityQueue<Cell> activeCells = new PriorityQueue<>();

            for(int i=500; i<500+N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=500; j<500+M; j++){
                    int life = Integer.parseInt(st.nextToken());
                    if(life == 0) continue;
                    map[i][j] = new Cell(i, j, life, life);
                    inactiveCells.add(map[i][j]);
                }
            }

            while(K --> 0){
                int inactiveSize = inactiveCells.size();
                // 사망
                die(deadCells);
                // 번식
                proliferation(inactiveCells, activeCells, deadCells, map);
                // 비활성->활성
                active(inactiveCells, activeCells, inactiveSize);
            }
            sb.append("#").append(t).append(" ").append(inactiveCells.size() + activeCells.size() + deadCells.size()).append("\n");
        }
        System.out.println(sb);
    }

    private static void active(Queue<Cell> inactiveCells, PriorityQueue<Cell> activeCells, int size) {

        for(int i=0; i<size; i++){
            Cell now = inactiveCells.poll();
            int x = now.x;
            int y = now.y;
            int life = now.life;
            int time = now.time;

            time--;
            if(time == 0){
                activeCells.offer(new Cell(x, y, life, life));
            }else{
                inactiveCells.offer(new Cell(x, y, life, time));
            }
        }
    }

    private static void proliferation(Queue<Cell> inactiveCell, PriorityQueue<Cell> activeCells, Queue<Cell> deadCells, Cell[][] map) {
        int size = activeCells.size();

        for(int i=0; i<size; i++){
            Cell now = activeCells.poll();
            int x = now.x;
            int y = now.y;
            int life = now.life;

            for(int j=0; j<4; j++){
                int cx = x + dx[j];
                int cy = y + dy[j];

                if(map[cx][cy] != null) continue;

                map[cx][cy] = new Cell(cx, cy, life, life);
                inactiveCell.offer(map[cx][cy]);

            }

            if(life-1 == 0) continue;
            deadCells.add(new Cell(x, y, life, life-1));
        }
    }

    private static void die(Queue<Cell> deadCells) {
        int size = deadCells.size();

        for(int i=0; i<size; i++){
            Cell now = deadCells.poll();

            now.time--;
            if(now.time == 0) continue;
            deadCells.offer(now);
        }
    }

    private static class Cell implements Comparable<Cell>{
        int x;
        int y;
        int life;
        int time;

        public Cell(int x, int y, int life, int time){
            this.x = x;
            this.y = y;
            this.life = life;
            this.time = time;
        }

        @Override
        public int compareTo(Cell c) {
            return Integer.compare(c.time, this.time);
        }
    }
}