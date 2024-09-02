import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 끊긴 기타줄
		int M = Integer.parseInt(st.nextToken()); // 브랜드 개수
		
		int minSetPrice = Integer.MAX_VALUE;
		int minSinglePrice = Integer.MAX_VALUE;
		
		// 브랜드별 세트 및 낱개 최소 가격 구하기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int setPrice = Integer.parseInt(st.nextToken());
			int singlePrice = Integer.parseInt(st.nextToken());
			
			if(minSetPrice > setPrice) {
				minSetPrice = setPrice;
			}
			
			if(minSinglePrice > singlePrice) {
				minSinglePrice = singlePrice;
			}
		}
		
		int method1 = (N / 6) * minSetPrice + (N % 6 != 0 ? minSetPrice : 0); // 세트	
		int method2 = (N / 6) * minSetPrice +(N % 6) * minSinglePrice; // 세트 + 낱개
		int method3 = N * minSinglePrice; // 낱개
		
		// method1, method2, method3 중 최소값을 출력
		System.out.println(Math.min(method1, Math.min(method2, method3)));
	}
}
