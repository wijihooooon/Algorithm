import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int grade[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			grade[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(grade);
		double average = 100;
		
		for(int i=0; i<N-1; i++) {
			average += ((double) grade[i] / grade[N-1]) * 100;
		}
		
		System.out.println(average / N);
		
	}

}
