import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> countMap = new TreeMap();
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			String s1 = s.substring(s.lastIndexOf('.') + 1);
			countMap.put(s1, countMap.getOrDefault(s1, 0) +1);
		}
		
		List<String> list = new ArrayList<>(countMap.keySet());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i) + (" ") + countMap.get(list.get(i)));
		}
	}

}