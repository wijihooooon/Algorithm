import java.io.*;
import java.util.*;

public class Main{

    public static int N;
    public static Spot spot[];
    public static boolean visited[];
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){

            N = Integer.parseInt(br.readLine());
            spot = new Spot[N+1];
            visited = new boolean[N+1];

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Spot home = new Spot(x, y, "home");

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                spot[i] = new Spot(x, y, "cvs");
            }
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            spot[N] = new Spot(x, y, "festival");

            sb.append(isPossible(home)).append("\n");
        }
        System.out.println(sb);
    }

    public static class Spot{
        int x;
        int y;
        String type;

        public Spot(int x, int y, String type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    public static String isPossible(Spot now){
        if(now.type.equals("festival")){
            return "happy";
        }

        for(int i=0; i<N+1; i++){
            if(visited[i]) continue;
            int startX = now.x;
            int startY = now.y;
            int nextX = spot[i].x;
            int nextY = spot[i].y;

            if(Math.abs(startX - nextX) + Math.abs(startY - nextY) <= 1000){
                visited[i] = true;
                String str = isPossible(spot[i]);
                if(str.equals("happy")) return "happy";
            }
        }
        return "sad";
    }
}