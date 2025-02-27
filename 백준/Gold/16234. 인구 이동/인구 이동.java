import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N, L, R;

    public static int[][] map;
    public static boolean[][] visited;

    public static ArrayList<ArrayList<Node>> list;

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        // 두 나라의 인구차이가 L명 이상 R명 이하이면 하루동안 국경 오픈
        // 국경이 열려있어 인접한 칸만을 이용해 이동할 수 있으면 하루동안 연합
        // 연합을 이루고 있는 각 칸의 인구수는 연합의 인구수/연합을 이루고 있는 칸의 개수
        // 연합을 해체하고 국경 봉쇄
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int count = 0;

        map = new int[N][N];
        // 국경 오픈 = 1, 봉쇄 = 0

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            visited = new boolean[N][N];

            list = new ArrayList<>();

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){

                        ArrayList<Node> union = unionCheck(i, j);

                        if(union.size() > 1){
                            list.add(union);
                        }
                    }
                }
            }

            if(list.isEmpty()) break;
            Move();
            count++;
        }
        System.out.println(count);
    }

    private static ArrayList<Node> unionCheck(int x, int y) {
        ArrayList<Node> union = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        Node start = new Node(x, y);
        q.add(start);
        visited[x][y] = true;
        union.add(start);

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<4; i++){
                int cx = node.x + dx[i];
                int cy = node.y + dy[i];

                if(cx>=0 && cy>=0 && cx<N && cy<N){
                    if(!visited[cx][cy]){
                        int population = Math.abs(map[node.x][node.y] - map[cx][cy]);
                        if(population >=L && population <= R){
                            visited[cx][cy] = true;
                            q.add(new Node(cx, cy));
                            union.add(new Node(cx, cy));
                        }
                    }
                }
            }
        }
        return union;
    }

    private static boolean Move() {
        boolean flag = false;
        for (ArrayList<Node> nodes : list) {
            int sum = 0;
            for (Node node : nodes) {
                sum += map[node.x][node.y];
            }

            for (Node node : nodes) {
                map[node.x][node.y] = sum / nodes.size();
            }
            flag = true;
        }
        return flag;
    }

    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
