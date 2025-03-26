import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static int[] village;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			village = new int[N+1];
			
			for(int i=1; i<N+1; i++) {
				village[i] = i;
			}
						
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			
            int count = 0;
            boolean[] checked = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                int root = find(i);
                if (!checked[root]) {
                    checked[root] = true;
                    count++;
                }
            }

            sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void union(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		
		if(nx!= ny) {
			village[nx] = ny;
		}
	}

	private static int find(int x) {
		if(village[x] != x) {
			village[x] = find(village[x]);	
		}
		return village[x];
	}
}