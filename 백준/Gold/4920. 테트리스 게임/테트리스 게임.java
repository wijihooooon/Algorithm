import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N;
		int T = 0;
		int[][] map;
		
		int[][] tetris = {
				{0, 0}, {0, 1}, {0, 2}, {0, 3},
				{0, 0}, {1, 0}, {2, 0}, {3, 0},
				{0, 0}, {0, 1}, {1, 1}, {1, 2},
				{0, 0}, {1, 0}, {1, -1}, {2, -1},
				{0, 0}, {0, 1}, {0, 2}, {1, 2},
				{0, 0}, {1, 0}, {2, 0}, {2, -1},
				{0, 0}, {1, 0}, {1, 1}, {1, 2},
				{0, 0}, {0, 1}, {1, 0}, {2, 0},
				{0, 0}, {0, 1}, {0, 2}, {1, 1},
				{0, 0}, {1, 0}, {2, 0}, {1, -1},
				{0, 0}, {1, 0}, {1, -1}, {1, 1},
				{0, 0}, {1, 0}, {2, 0}, {1, 1},
				{0, 0}, {1, 0}, {0, 1}, {1, 1},
		};
		
		while(true) {
			T++;
			
			N = Integer.parseInt(br.readLine().trim());
			
			if(N == 0) break;
			
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = Integer.MIN_VALUE;
			int sum;
			for(int i=0; i<N; i++) {
				
				for(int j=0; j<N; j++) {
					for(int k=0; k<tetris.length; k+=4) {
						sum = 0;
						boolean check = false;
						for(int l=k; l<k+4; l++) {
							int cx = i + tetris[l][0];
							int cy = j + tetris[l][1];
							
							if(cx<0 || cy<0 || cx>=N || cy>=N) {
								check = true;
								break;
							}
							sum += map[cx][cy];
						}
						if(!check) {
							max = Math.max(max, sum);
						}
					}
				}
			}
			
			sb.append(T).append(". ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}