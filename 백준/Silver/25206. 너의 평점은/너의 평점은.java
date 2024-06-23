import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// (학점 * 과목평점) / 학점총합
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		double score1 = 0;//학점*과목평점
		double score2 = 0;//학점총합
		
		for(int i=0; i<20; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();// 버리는거
			
			Double num = Double.parseDouble(st.nextToken());// 학점
			score2 += num;
			
			// 과목 평점 * 학점
			switch(st.nextToken()) {
			case "A+":
				score1 += (4.5 * num);
				break;
			case "A0":
				score1 += (4.0 * num);
				break;
			case "B+":
				score1 += (3.5 * num);
				break;
			case "B0":
				score1 += (3.0 * num);
				break;
			case "C+":
				score1 += (2.5 * num);
				break;
			case "C0":
				score1 += (2.0 * num);
				break;	
			case "D+":
				score1 += (1.5 * num);
				break;
			case "D0":
				score1 += (1.0 * num);
				break;
			case "F":
				score1 += (0.0 * num);
				break;
			case "P":
				score2 -= num;
				break;
			}
		}
		System.out.printf("%.6f\n", score1 / score2);
	}
}
