import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int check = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(check == 1) { // 확인하는 연산
				if(find(a) == find(b)) {
					sb.append("YES\n");
				}else {
					sb.append("NO\n");
				}
			}else { // union 연산
				union(a, b);
			}
		}
		System.out.println(sb);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			if(a < b) {
				arr[b] = a;
			}else {
				arr[a] = b;
			}
		}
	}

	private static int find(int a) {
		if(a == arr[a]) {
			return a;
		}
		return arr[a] = find(arr[a]);
	}

}
