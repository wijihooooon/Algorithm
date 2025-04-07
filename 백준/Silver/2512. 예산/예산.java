import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] budget = new int[N];
		int maxVal = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			maxVal = Math.max(budget[i], maxVal);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		findBudget(budget, M, maxVal);
	}

	private static void findBudget(int[] budget, int M, int maxVal) {
		int start = 1;
		int end = maxVal;
		int result = 0;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(isPossible(budget, M, mid)) {
				result = mid;
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		System.out.println(result);
	}

	private static boolean isPossible(int[] budget, int M, int mid) {
		int sum = 0;
		for(int money : budget) {
			if(mid > money) {
				sum += money;
			}else {
				sum += mid;
			}
		}
		return sum<=M;
	}
}
/*
 * 풀이 아이디어
 *  상한액을 기준으로 파라매트릭 서치 최대값 구하기.
 */