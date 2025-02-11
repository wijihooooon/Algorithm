import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;

        int[][][] map = new int[N][M][2];

        // 뒤집을 배열
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j][0] = str.charAt(j) - '0';
            }
        }
        // 정답 배열
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j][1] = str.charAt(j) - '0';
            }
        }

        // 전체 탐색하면서 map이 0이면 1 1이면 0으로 변경
        for(int i=0; i<=N-3; i++) {
            for(int j=0; j<=M-3; j++) {
                if(map[i][j][0] != map[i][j][1]) {
                    count++;
                    for(int k=i; k<i+3; k++){
                        for(int l=j; l<j+3; l++){
                            if(map[k][l][0] == 0) {
                                map[k][l][0] = 1;
                            }else{
                                map[k][l][0] = 0;
                            }
                        }
                    }
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j][0] != map[i][j][1]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);

    }
}
