import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken()); // 층 수
			int W = Integer.parseInt(st.nextToken()); // 층별 방 개수
			int N = Integer.parseInt(st.nextToken()); // 몇번째 손님
			
			int floor = N % H == 0 ? H : N % H;
            int roomNumber = (N - 1) / H + 1;
			
			sb.append(floor).append(String.format("%02d",roomNumber)).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
