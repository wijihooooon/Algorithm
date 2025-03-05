import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static int H, W;
	
	public static char[][] map;
	
	public static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static Point tank;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			
			for(int i=0; i<H; i++) {
				String str = br.readLine();
				for(int j=0; j<W; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '^') {
						tank = new Point(i, j, 0);
					}else if(map[i][j] == 'v') {
						tank = new Point(i, j, 1);
					}else if(map[i][j] == '<') {
						tank = new Point(i, j, 2);
					}else if(map[i][j] == '>') {
						tank = new Point(i, j, 3);
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String commandList = br.readLine();
			
			for(int i=0; i<commandList.length(); i++) {
				char command = commandList.charAt(i);

				switch (command) {
				case 'U':
					Move(tank, 0, '^');
					break;
				case 'D':
					Move(tank, 1, 'v');
					break;
				case 'L':
					Move(tank, 2, '<');
					break;
				case 'R':
					Move(tank, 3, '>');
					break;
				case 'S':
					Boom(tank);
					break;
				}
			}
			
			sb.append("#").append(t).append(" ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	private static void Boom(Point tank) {
		int x = tank.x;
		int y = tank.y;
		int d = tank.d;
		
		while(true) {
			x += direction[d][0];
			y += direction[d][1];

			if(x<0 || y<0 || x>=H || y>=W) break;
			
			if(map[x][y] == '*') {
				map[x][y] = '.';
				break;
			}else if(map[x][y] == '#') {
				break;
			}
		}
	}
	private static void Move(Point tank,int d, char sign) {
		int x = tank.x;
		int y = tank.y;
		tank.d = d;
		
		int newX = x + direction[d][0];
		int newY = y + direction[d][1];
		
		if(newX>=0 && newY>=0 && newX<H && newY<W) {
			if(map[newX][newY] == '.') {
				tank.x = newX;
				tank.y = newY;
				map[newX][newY] = sign;
				map[x][y] = '.';
				return;
			}
		}
		map[x][y] = sign;
	}
	public static class Point{
		int x;
		int y;
		int d;
		
		public Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
