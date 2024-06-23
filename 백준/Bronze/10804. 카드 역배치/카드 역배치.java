import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int card[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			for(int j = A-1, k = B-1; j<k; j++, k--) {
				int change = card[j];
				card[j] = card[k];
				card[k] = change;
			}
			
		}
		for(int j=0; j<20; j++) {
			System.out.print(card[j] + " ");
		}
	}

}