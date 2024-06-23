import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 투포인터 연습
class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int n[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int j=0; j<N; j++) {
			n[j] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.parallelSort(n);
		
		int X = Integer.parseInt(br.readLine());
		int count = 0;
		
		int start = 0;
		int end =  N - 1;
		int sum = 0;
		
		while(start < end) {
			sum = n[start] + n[end];
			if(sum == X) {
				count++;
			}
			
			if(sum <= X) {
				start++;
			}else {
				end--;
			}
		}
		
		System.out.println(count);
	}

}