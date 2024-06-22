import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> tMap = new TreeMap<>();
		
		int count = 0;
		
		for(int i=0; i<n+m; i++) {
			String s = br.readLine();
			
			tMap.put(s, tMap.getOrDefault(s, 0)+1);
			if(tMap.get(s) == 2) {
				count++;
			}
		}
		
		System.out.println(count);
		
		for(String s : tMap.keySet()) {
			if(tMap.get(s) > 1) {
				System.out.println(s);
			}
		}

	}
}