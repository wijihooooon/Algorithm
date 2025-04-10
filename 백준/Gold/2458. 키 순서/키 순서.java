import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] height = new boolean[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			height[a][b] = true;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(height[i][k] && height[k][j]) {
						height[i][j] = true;
					}
				}
			}
		}
		
		int ans = 0;
		
		for(int i=1; i<=N; i++) {
			int count = 0;
			for(int j=1; j<=N; j++) {
				if(height[i][j]) count++;
				if(height[j][i]) count++;
			}
			if(count == N-1) ans++;
		}
		System.out.println(ans);
	}
}
/*
 * 풀이아이디어
 * 플로이드-워셜을 활용
 * */