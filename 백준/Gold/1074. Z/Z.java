import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, r, c, cnt;
    public static int[][] zSearch = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cnt = 0;

        Z(0, 0, N);
    }

    private static void Z(int x, int y, int step) {
        if(step == 1){
            for(int i=0; i<4; i++){
                if(x+zSearch[i][0] == r && y+zSearch[i][1] == c){
                    System.out.println(cnt);
                    System.exit(0);
                }
                cnt++;
            }
        }

        int plus = (int) Math.pow(2, step) / 2;

        if(r < x + plus && c < y + plus){
            Z(x, y, step-1);
        }else if(r < x + plus && c < y + 2 * plus){
            cnt += plus * plus;
            Z(x, y + plus, step-1);
        }else if(r < x + 2 * plus && c < y + plus){
            cnt += plus * plus * 2;
            Z(x + plus, y, step-1);
        }else if(r < x + 2 * plus && c < y + 2 * plus){
            cnt += plus * plus * 3;
            Z(x + plus, y + plus, step-1);
        }
    }
}