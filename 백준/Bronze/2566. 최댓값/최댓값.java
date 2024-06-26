import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int max = Integer.MIN_VALUE;
		int x = 0;
		int y = 0;
		for(int i=1; i<=9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=9; j++) {
				int temp = max;
				max = Math.max(max, Integer.parseInt(st.nextToken()));
				if(max != temp) {
					x = i;
					y = j;
				}
			}
		}
		System.out.println(max);
		System.out.println(x +" " + y);
		
	}
}
