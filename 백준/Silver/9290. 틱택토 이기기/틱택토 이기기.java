import java.util.*;
import java.io.*;

public class Main {  
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        char map[][];

        for(int t=0; t<T; t++){
            sb.append("Case " + (t+1) + ":");
            sb.append("\n");

            map = new char[3][3];

            for(int i=0; i<3; i++){
                String str = br.readLine();
                for(int j=0; j<3; j++){
                    map[i][j] = str.charAt(j);
                }
            }

            char chr = br.readLine().charAt(0);

            for(int i=0; i<3; i++){
                boolean chk = false;
                for(int j=0; j<3; j++){
                    if(map[i][j] == '-'){
                        chk = check(i, j, map, chr);
                    }

                    if(chk){
                        for(int k=0; k<3; k++){
                            for(int l=0; l<3; l++){
                                if(i == k && j == l) {
                                    sb.append(chr);
                                    continue;
                                }
                                sb.append(map[k][l]);
                            }
                            sb.append("\n");
                        }
                        
                        break;
                    }
                }
                if(chk) break;
            }
        }
        System.out.println(sb);
    }

    public static boolean check(int i, int j, char[][] map, char chr){
        boolean row = true;
        for (int k = 0; k < 3; k++) {
            char v = (k == j) ? chr : map[i][k];
            if (v != chr) { row = false; break; }
        }
        if (row) return true;

        boolean col = true;
        for (int k = 0; k < 3; k++) {
            char v = (k == i) ? chr : map[k][j];
            if (v != chr) { col = false; break; }
        }
        if (col) return true;

        if (i == j) {
            boolean diag1 = true;
            for (int k = 0; k < 3; k++) {
                char v = (k == i) ? chr : map[k][k];
                if (v != chr) { diag1 = false; break; }
            }
            if (diag1) return true;
        }

        if (i + j == 2) {
            boolean diag2 = true;
            for (int k = 0; k < 3; k++) {
                int r = k;
                int c = 2 - k;
                char v = (r == i && c == j) ? chr : map[r][c];
                if (v != chr) { diag2 = false; break; }
            }
            if (diag2) return true;
        }

        return false;
    }
}