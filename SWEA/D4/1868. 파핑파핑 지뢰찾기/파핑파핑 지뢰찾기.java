import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

	public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int count = 0;
			
			char[][] map = new char[N][N];
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == '.') {
						boolean flag = true;
						for(int k=0; k<8; k++) {
							if(i+dx[k]>=0 && j+dy[k]>=0 && i+dx[k]<N && j+dy[k]<N) {
								if(map[i+dx[k]][j+dy[k]] == '*') {
									flag = false;
									break;
								}
							}
							
						}
						
						if(flag) {
							count++;
							Queue<Node> q = new ArrayDeque<>();
							q.add(new Node(i, j));
							map[i][j] = '0';
							
							while(!q.isEmpty()) {
								Node now = q.poll();
								
								for(int l=0; l<8; l++) {
									int cx = now.x + dx[l];
									int cy = now.y + dy[l];
									
									if(cx>=0 && cy>=0 && cx<N && cy<N) {
										if(map[cx][cy] == '.') {
											int countBoomb = 0;
											for(int m=0; m<8; m++) {
												if(cx + dx[m] >= 0 && cx + dx[m] < N && cy + dy[m] >= 0 && cy + dy[m] < N) {
													if(map[cx+dx[m]][cy+dy[m]] == '*') {
														countBoomb++;
													}
												}
											}
											
											if(countBoomb == 0) {
												map[cx][cy] = '0';
												q.add(new Node(cx, cy));
											}else {
												map[cx][cy] = (char) (countBoomb + '0');
											}
										}
									}
								}
							}
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.') {
						count++; 
		            }
		        }
		    }
			
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
public static class Node {
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
}
