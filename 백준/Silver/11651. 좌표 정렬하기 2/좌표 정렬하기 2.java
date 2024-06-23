import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][0] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) ->{
			if(o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}else {
				return o1[0] - o2[0];
			}
		});
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i][1]).append(" ").append(arr[i][0]).append("\n");
		}
		
		System.out.println(sb);
	}

}
