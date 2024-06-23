import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][M];
		
		for(int j=0; j<N; j++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<M; k++) {
				map[j][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int j=0; j<N; j++) {
			for(int k=0; k<M; k++) {
				if(j == 0 && k !=0) {
					map[j][k] += map[j][k-1];
				}else if(j != 0 && k == 0) {
					map[j][k] += map[j-1][k];
				}else if(j>0 && k>0) {
					map[j][k] += Math.max(map[j-1][k], map[j][k-1]);
				}
			}
		}
		
		System.out.println(map[N-1][M-1]);
		
	}

}