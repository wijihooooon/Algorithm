import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num[] = new int[3];
		
		for(int j=0; j<3; j++) {
			num[j] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		for(int i=0; i<num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}
}