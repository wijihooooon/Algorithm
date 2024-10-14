import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int card1[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			card1[i] = Integer.parseInt(st.nextToken());
		}
		
		N = Integer.parseInt(br.readLine());
		int card2[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			card2[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card1);
		
		binarySerach(card1, card2);
		
		System.out.println(sb);
		
	}

	private static void binarySerach(int[] card1, int[] card2) {
		int start;
		int end;
		
		for(int i=0; i<card2.length; i++) {
			
			boolean check = false;
			start = 0;
			end = card1.length-1;
			
			while(start <= end) {
				int mid = (start + end) / 2;
				
				if(card2[i] < card1[mid]) {
					end = mid - 1;
				}else if(card2[i] > card1[mid]) {
					start = mid + 1;
				}else if(card2[i] == card1[mid]) {
					check = true;
					break;
				}
			}
			
			if(check) {
				sb.append("1");
			}else {
				sb.append("0");
			}
			sb.append(" ");
		}
		
		
		
	}

}
