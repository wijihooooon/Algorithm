import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	public static LinkedList<Integer>[] gear;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	
		
		for(int t=1; t<=T; t++) {
			int K = Integer.parseInt(br.readLine());
			gear = new LinkedList[4];
			
			for(int i=0; i<4; i++) {
				gear[i] = new LinkedList<>();
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					gear[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int who = Integer.parseInt(st.nextToken())-1;
				int dir = Integer.parseInt(st.nextToken());
				int newDir = dir;
				int nowL = gear[who].get(6);
				int nowR = gear[who].get(2);
				
				// 좌
				for(int j = who-1; j>=0; j--) {
					if(gear[j].get(2) == nowL) {
						break;
					}
					nowL = gear[j].get(6);
					newDir *= -1; 
					rotate(j, newDir);
				}
				
				newDir = dir;
				// 우
				for(int j = who+1; j<4; j++) {
					if(gear[j].get(6) == nowR) {
						break;
					}
					nowR = gear[j].get(2);
					newDir *= -1; 
					rotate(j, newDir);
				}		
				rotate(who, dir);			
			}
			
			int ans = 0;
			int weight = 1;
			
			for(int i=0; i<4; i++) {
				if(gear[i].get(0) == 1) ans += weight;
				weight *= 2;
			}			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static void rotate(int who, int dir) {
		if(dir == 1) { // 시계
			gear[who].addFirst(gear[who].getLast());
			gear[who].removeLast();
		}else { // 반시계
			gear[who].addLast(gear[who].getFirst());
			gear[who].removeFirst();
		}
	}
}