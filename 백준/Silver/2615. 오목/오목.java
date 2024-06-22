import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int board[][];
	
	public static int[] dx = {0, 1, 1, -1}; // 우 하 우하 상우
	public static int[] dy = {1, 0, 1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		board = new int[19][19];
		
		for(int i=0; i<19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				if(board[i][j] == 1 || board[i][j] == 2) {
					if(winnerCheck(i, j, board[i][j]) == 5) {
						System.out.println(board[i][j]);
						System.out.println((i+1) + " " + (j+1));
						return;
					}
				}
			}
		}
		System.out.println(0);
	}

	private static int winnerCheck(int x, int y, int color) {
		for(int i=0; i<4; i++) {
			
			int cx = x + dx[i];
			int cy = y + dy[i];
			
			int count = 1;

			while(cx>=0 && cy>=0 && cx<19 && cy<19 && board[cx][cy] == color) {
				count++;
				cx += dx[i];
				cy += dy[i];
				
			}
			
			boolean check = false;
			if(count == 5) {
				
				if((i == 0 && y-1 >= 0 && board[x][y-1] == color) || (i == 1 && x-1 >=0 && board[x-1][y] == color) || (i == 2 && x-1>=0 && y-1>=0 && board[x-1][y-1] == color) || (i == 3 && x+1 < 19 && y-1>=0 && board[x+1][y-1] == color)) {
					check = true;
				}
				
				if(!check) {
					return count;
				}
				
			}
			
		}
		return 0;
	}

}