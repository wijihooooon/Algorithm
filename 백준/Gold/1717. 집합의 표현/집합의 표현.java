import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int arr[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		arr = new int[N+1];
		
		for(int i=0; i<N+1; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(check == 1) { // 1이면 확인
				if (find(x) == find(y)) {
					sb.append("YES").append("\n");
				}else {
					sb.append("NO").append("\n");
				}
			}else { // 0이면 합집합
				union(x, y);
			}
		}
		
		System.out.println(sb);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			if(x < y) {
				arr[x] = y;
			}else {
				arr[y] = x;
			}
		}
		
	}

	private static int find(int x) {
		if(x == arr[x]) {
			return x;
		}
		return arr[x] = find(arr[x]);
	}

}
