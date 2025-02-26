import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static int M, ans;
	
	public static ArrayList<Node> chicken;
	public static ArrayList<Node> house;
	
	public static int[][] map;
	public static Node[] temp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		temp = new Node[M];
		
		chicken = new ArrayList<>();
		house = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					house.add(new Node(i, j));
				}else if(map[i][j] == 2) {
					chicken.add(new Node(i, j));
				}
			}
		}
		
		ans = Integer.MAX_VALUE;

		dfs(0, 0);
		
		System.out.println(ans);
	}

	private static void dfs(int start, int cnt) {
		if(cnt == M) {
			int chickenStreet = 0;
			for(Node h : house) {
				int chickenToHouse = Integer.MAX_VALUE;
				for(Node c : temp) {
					chickenToHouse = Math.min(chickenToHouse, Math.abs(h.x - c.x) + Math.abs(h.y - c.y));
				}
				chickenStreet += chickenToHouse;
			}
			ans = Math.min(ans, chickenStreet);
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			temp[cnt] = chicken.get(i);
			dfs(i+1, cnt+1);
		}
		
	}
	
	private static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
