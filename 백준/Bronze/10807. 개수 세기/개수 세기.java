import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int j=0; j<N; j++) {
			num[j] = Integer.parseInt(st.nextToken());
		}
		int V = Integer.parseInt(br.readLine());
		int count = 0;
		for(int j=0; j<N; j++) {
			if(num[j] == V) {
				count++;
			}
		}
		System.out.println(count);
	}

}