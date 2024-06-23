import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
// 45분 전으로 만들기
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int m = b - 45;
		
		if(m<0) {
			m += 60;
			a--;
		}
		
		if(a<0) {
			a = 23;
		}
		
		System.out.println(a + " " + m);
	}

}
