import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 인접리스트
		List<Integer>[] list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 진입차수 저장할 배열
		int[] deg = new int[N+1];
		
		// 간선 정보 넣고 진입차수++;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			deg[b]++;
		}
		
		// 진입 차수가 0인 정점을 큐에 삽입
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(deg[i] == 0) q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for(int next : list[cur]) {
				deg[next]--;
				if(deg[next] == 0) q.add(next);
			}
		}
		System.out.println(sb);
		
	}

}
