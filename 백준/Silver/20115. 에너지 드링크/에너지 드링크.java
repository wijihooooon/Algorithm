import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 에너지 드링크 수

		int bigNum = 0;
		double sum = 0;
		
		int num1 = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num1 = Integer.parseInt(st.nextToken());

			if(num1 > bigNum) {
				sum += bigNum/2.0;
				bigNum = num1;
			}else {
				sum += num1/2.0;
			}
			
		}
		System.out.println(sum + bigNum);
	}
}