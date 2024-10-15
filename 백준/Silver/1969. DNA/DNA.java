import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int count[][] = new int[M][4]; // 각 배열 에서 ACTG의 갯수를 직접 셈
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				switch (s.charAt(j)){
				case 'A':
					count[j][0]++;
					break;
				case 'C':
					count[j][1]++;
					break;
				case 'G':
					count[j][2]++;
					break;
				case 'T':
					count[j][3]++;
					break;
				}
			}
		}
		
		int HammingDistance = 0;
		
		for(int i=0; i<M; i++) {
			int max = Math.max(count[i][0],Math.max(count[i][1], Math.max(count[i][2], count[i][3]))); // 최대 값 구하기
			
			int counter = 0;
			int ans = 0;
			
			HammingDistance += N - max;
			
			for(int j=0; j<4; j++) { // 최대값을 가지는 DNA가 몇개인지 확인
				if(count[i][j] == max) {
					counter++;
					ans = j;
				}
			}
			
			if(counter >= 2) { // 최대값이 2개이상 -> 최대값을 가지는 DNA중 사전순
				for(int j=0; j<4; j++) {
					if(count[i][j] == max) {
						ans = j;
						break;
					}
				}
			}
			
			switch(ans){
			case 0:
				sb.append("A");
				break;
			case 1:
				sb.append("C");
				break;
			case 2:
				sb.append("G");
				break;
			case 3:
				sb.append("T");
				break;
			}
			
		}
		
		System.out.println(sb);
		System.out.println(HammingDistance);
		
	}
}
