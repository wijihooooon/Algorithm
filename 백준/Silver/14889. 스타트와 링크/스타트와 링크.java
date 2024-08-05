import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
/* 	모든 조합을 구해서 배열에 넣고 
   	배열의 형태가 다음과 같을떄
	[0][1][2][3][4][5][6]
	0은 6, 1은 5 .. 이렇게 두값의 차를 출력
*/
	public static int N;
	public static int map[][];
	public static boolean visited[];
	public static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		// map에 값 삽입
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BackTracking(0, 1);
		
		int min = Integer.MAX_VALUE;
		/* list에 들어있는 수를가지고
		 * [0][1][2][3][4][5][6]
		   0은 6, 1은 5 .. 이렇게 두값의 차를 구해 그중 최소값을 출력
		 * */
		for(int i=0; i<list.size()/2; i++) {
			min = Math.min(Math.abs(list.get(i) - list.get(list.size()-1-i)), min);
		}
		System.out.println(min);
	}
	
	private static void BackTracking(int cnt, int start) {
		if(cnt == N/2) {
			int sum = 0;
			ArrayList<Integer> cleanNum = new ArrayList<>();
			for(int i=1; i<=N; i++) {
				if(visited[i]) {
					cleanNum.add(i);
				}
				
			}
			
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<N/2; j++) {
					sum += map[cleanNum.get(i)][cleanNum.get(j)];
				}
			}
			list.add(sum);
			
			return;
		}
		
		for(int i=start; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				BackTracking(cnt+1, i+1);
				visited[i] = false;
			}
		}
	}

}
