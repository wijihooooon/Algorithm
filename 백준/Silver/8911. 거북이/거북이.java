import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int dx[] = {-1, 0, 1, 0}; // 상 좌 하 우
	public static int dy[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			
			int dir = 0;
			int x = 500;
			int y = 500;
			
			int minX = x;
			int minY = y;
			int maxX = x;
			int maxY = y;
			
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) == 'F') {
					x += dx[dir];
					y += dy[dir];
				}else if(str.charAt(j) == 'B') {
					x += dx[(dir+2) % 4];
					y += dy[(dir+2) % 4];
				}else if(str.charAt(j) == 'L') {
					dir = (dir+1)%4;
				}else if(str.charAt(j) == 'R') {
					dir = ((dir+3)%4);
				}
				
				minX = Math.min(minX, x);
				minY = Math.min(minY, y);
				maxX = Math.max(maxX, x);
				maxY = Math.max(maxY, y);
			}
			
			System.out.println((maxX-minX) * (maxY-minY));
			
		}
		
	}

}
