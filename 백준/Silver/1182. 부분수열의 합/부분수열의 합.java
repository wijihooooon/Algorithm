import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N, M;
	
	public static int num[];
	public static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		count = 0;
		
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0, 0);
		
		if(M == 0) {
			count -= 1;
		}
		System.out.println(count);
	}

	private static void func(int x, int sum) {
		if(x == N) {
			if(sum == M) {
				count++;
			}
			
			return;
		}
		
		func(x+1, sum); // 선택안함
		func(x+1, sum+num[x]); // 선택함
	}
}