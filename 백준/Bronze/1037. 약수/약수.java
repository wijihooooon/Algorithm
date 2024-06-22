import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		
		for(int j=0; j<N; j++) {
			num[j] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		if(num.length == 1) {
			System.out.println(num[0] * num[0]);
		}else {
			System.out.println(num[0] * num[num.length-1]);
		}
	}
}
