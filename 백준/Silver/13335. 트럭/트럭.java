import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 트럭 개수
		int W = Integer.parseInt(st.nextToken()); // 다리의 길이
		int L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중
		
		 Queue<Integer> trucks = new LinkedList<>();
	     Queue<Integer> bridge = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			trucks.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < W; i++) {
            bridge.add(0); 
        }
		
		int time = 0;
		int currentWeight = 0;
		
		while(!bridge.isEmpty()) {
			time++;
			currentWeight -= bridge.poll();
			
			if(!trucks.isEmpty()) {
				if(currentWeight + trucks.peek() <= L) {
					int truck = trucks.poll();
					bridge.add(truck);
					currentWeight += truck;
				}else {
					bridge.add(0);
				}
			}
		}
		
		System.out.println(time);
	}

}
