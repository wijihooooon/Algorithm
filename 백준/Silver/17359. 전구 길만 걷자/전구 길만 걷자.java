import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 그냥 백트레킹으로 풀면 시간초가가 나서 각 전구 묶음마다 몇번씩 변하는지 구하고
 * 백트래킹하면서 연결되는 부분의 변화 유무만 더해 최소값 추출
 * */
public class Main {

	public static int N, min, ans;
	public static String light[];
	public static boolean visited[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ans = 0;
		min = Integer.MAX_VALUE;
		
		light = new String[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			light[i] = br.readLine();
			// 각 전구 묶음내에서 01/10변하는거 찾아내기
			innerChange(light[i]);
		}

		backTracking(0, -1, 0);
		
		System.out.println(ans + min);
	}
	// 각 전구 묶음내에서 변화 수 세기
	private static void innerChange(String str) {
		for(int i=0; i<str.length()-1; i++) {
			if(str.charAt(i) != str.charAt(i+1)) {
				ans++;
			}
		}
	}

	// 백트래킹으로 조합 만들면서 연결되는 부분 바뀌는거 세기
	private static void backTracking(int cnt, int lastIndex, int count) {
		if(min <= count) {
			return;
		}
		// cnt가 N이되면 N개로 만들수 있는 조합이 구해짐
		if(cnt == N) {
			min = Math.min(min, count);
			return;
		}		
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				
				visited[i] = true;
				
				int newCount = count;
				// 문자열을 수정하는 연산을 할때마다 새로운 문자역 객체가 생성되기 때문에 메모리 사용량 증가와 추가적인 연산 비용을 초래할 수 있다.
				if(lastIndex != -1 && light[lastIndex].charAt(light[lastIndex].length() - 1) != light[i].charAt(0)) {
					newCount++;
				}
				
				backTracking(cnt+1,i, newCount);
				
				visited[i] = false;
			}
		}
	}

}
