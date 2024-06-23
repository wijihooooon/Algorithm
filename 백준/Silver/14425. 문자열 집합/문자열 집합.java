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
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int count = 0;
		
		Map<String, Integer> hMap = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			hMap.put(br.readLine(), 0);
		}
		
		for(int i=0; i<m; i++) {
			if(hMap.containsKey(br.readLine())) {
				count++;
			}
		}
		
		System.out.println(count++);
	}

}