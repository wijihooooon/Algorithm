import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int j=0; j<7; j++) {
			int A = Integer.parseInt(br.readLine());
			if(A % 2 != 0 ) {
				list.add(A);
			}
		}
		Collections.sort(list);
		
		int sum = 0;
		
		if(list.isEmpty()) {
			System.out.println("-1");
		}else {
			
			for(int k=0; k<list.size(); k++) {
				sum += list.get(k); 
			}
			
		System.out.println(sum);
		System.out.println(list.get(0));
		
		}
	}
}