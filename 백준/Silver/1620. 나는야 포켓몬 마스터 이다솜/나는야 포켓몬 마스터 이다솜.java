import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			map.put(str, String.valueOf(i + 1));
			map.put(String.valueOf(i + 1), str);
		}
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			System.out.println(map.get(str));
		}
	
	}

}
