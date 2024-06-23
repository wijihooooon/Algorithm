import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
// 양방향 + 한점에서 여러곳으로 텔레포트 할수 있음!!!
public class Main {
	public static int N, M, S, E;

	public static Queue<Integer> q;
	
	public static int[] map;
	public static List<Integer>[] tpMap;
	
	//public static int[] tpMap;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 총 거리 1~N
		M = Integer.parseInt(st.nextToken()); // 텔포 갯수
		
		map = new int[N+1];
		tpMap = new ArrayList[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		q = new LinkedList<>();
		
		S = Integer.parseInt(st.nextToken()); // 시작점
		E = Integer.parseInt(st.nextToken()); // 도착점
		
		map[S] = 1;
		q.add(S);
		
		for(int j=0; j<=N; j++) {
			tpMap[j] = new ArrayList<>();
		}
		
		for(int j=0; j<M; j++) { // 텔포 있는곳 은 1로 표시
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tpMap[a].add(b);
			tpMap[b].add(a);
		}
		
		bfs();
	}

	private static void bfs() {
		int now;
		
		while(!q.isEmpty()) {
			now = q.poll();
			
			if(now == E) { // 도착시 출력후 탈출
				System.out.println(map[now] - 1);
				return;
			}
			
			if(!tpMap[now].isEmpty()) { // tp 하기
				for(int j=0; j<tpMap[now].size(); j++) {
					if(map[tpMap[now].get(j)] == 0) {
						q.add(tpMap[now].get(j));
						map[tpMap[now].get(j)] = map[now] + 1;
					}
				}
				
			} 
			
			if(now + 1 <= N && map[now + 1] == 0) { // +1
					map[now + 1] = map[now] + 1;
					q.add(now + 1);
			}	
			
			if(now - 1 > 0  && map[now - 1] == 0) { // -1
				map[now - 1] = map[now] + 1;
				q.add(now - 1);
			}	
			
		}
	}

}