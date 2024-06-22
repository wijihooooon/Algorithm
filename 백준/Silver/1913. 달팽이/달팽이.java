import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		
		int map[][] = new int[N][N];
		
		int dx[] = {1, 0, -1, 0}; // 하 우 상 좌 순으로 순회 
		int dy[] = {0, 1, 0, -1};
		
		map[0][0] = N*N;
		
		int x = 0;
		int y = 0;
		int a = 0;
		
		while(true) {
			if(a == 4) {
				a = (a % 3) - 1;
			}
			
			int cx = x +dx[a];
			int cy = y + dy[a];
			
			if(cx>=0 && cy>=0 && cx<N && cy<N && map[cx][cy] == 0) {
				map[cx][cy] = map[x][y] - 1;
				x = cx;
				y = cy;
			}else {
				a++;
			}
			
			if(map[x][y] == 1) {
				break;
			}
		}
		
		for(int j=0; j<N; j++) {
			for(int k=0; k<N; k++) {
				sb.append(map[j][k]).append(" ");
				if(map[j][k] == target) {
					x = j;
					y = k;
				}
			}
			sb.append("\n");
		}
		sb.append(x+1).append(" ").append(y+1);
		System.out.println(sb);
	}
}
