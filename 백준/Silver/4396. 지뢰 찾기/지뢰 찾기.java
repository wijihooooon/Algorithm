import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static char map[][];

	public static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	public static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		boolean mine_check = false;
		
		for(int i=0; i<N; i++) { // 지도에 지뢰매설~
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		
		for(int i=0; i<N; i++) { // 밟은 땅 오픈~
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				if(s.charAt(j) == 'x' && map[i][j] != '*') {
					map[i][j] = '0';
				}else if(map[i][j] == '*' && s.charAt(j) == 'x') {
					mine_check = true;
				}
			}
		}
		
		for(int i=0; i<N; i++) { // 지뢰탐지
			for(int j=0; j<N; j++) {
				if(map[i][j] == '0') {
					for(int k=0; k<8; k++) {
						int cx = i + dx[k];
						int cy = j + dy[k];
						
						if(cx>=0 && cy>=0 && cx<N && cy<N) {
							if(map[cx][cy] == '*') {
								map[i][j] += 1;
							}
						}
					}
				}
			}
		}
		if(mine_check) {
			for(int i=0; i<N; i++) { // 지뢰 밟아서 그대로 다 출력
				for(int j=0; j<N; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}else {
			for(int i=0; i<N; i++) { // 지뢰 안 밟아서 지뢰 흙 덮고 출력
				for(int j=0; j<N; j++) {
					if(map[i][j] == '*') {
						map[i][j] = '.';
					}
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		
		
	}
}