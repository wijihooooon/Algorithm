import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static int bingoBoard[][] = new int[6][6];
	public static List<Integer> list[] = new ArrayList[26]; 
	public static boolean check[][] = new boolean[6][6];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for(int i=1; i<=5; i++) { // 빙고판에 번호 삽입
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=5; j++) {
				bingoBoard[i][j] = Integer.parseInt(st.nextToken());
				list[bingoBoard[i][j]] = new ArrayList<>();
				list[bingoBoard[i][j]].add(i);
				list[bingoBoard[i][j]].add(j);
			}
		}
		
		for(int i=0; i<5; i++) { // 사회자 번호 부름
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				check[list[num].get(0)][list[num].get(1)] = true; // 번호 체크
					if(check() == 3) {
						System.out.println((i*5)+j+1);
						return;
					}
			}
		}
		System.out.println("?");
	}

	private static int check() {
		int count = 0;
		
		for(int i=1; i<=5; i++) { 
			int row = 0;
			int column = 0;
			for(int j=1; j<=5; j++) {
				if(check[i][j]) { // 가로 체크
					row++;
				}
				if(check[j][i]) { // 세로 체크
					column++;
				}
			}
			if(row == 5) {
				count++;
			}
			if(column == 5) {
				count++;
			}
		}
		
		if(check[1][1] && check[2][2] && check[3][3] && check[4][4] && check[5][5]) {
			count++;
		}
		
		if(check[1][5] && check[2][4] && check[3][3] && check[4][2] && check[5][1]) {
			count++;
		}
		
		if(count >= 3) {
			return 3;
		}else {
			return 0;
		}
		
	}
}
