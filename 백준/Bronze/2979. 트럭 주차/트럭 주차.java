import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int park[] = new int[101];
		
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			for(int j=start; j<end; j++) {
				park[j]++;
			}
		}
		
		int sum = 0;
		
		for(int i=0; i<park.length; i++) {
			if(park[i] == 1) {
				sum += A;
			}else if(park[i] == 2) {
				sum += B * 2;
			}else if(park[i] == 3) {
				sum += C * 3;
			}
		}
		
		System.out.println(sum);
		
	}

}
