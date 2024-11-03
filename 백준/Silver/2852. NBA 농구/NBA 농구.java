import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 득점 횟수
		
		int t1 = 0;
		int t2 = 0;
		
		int t1Time = 0; // 초단위로 계산
		int t2Time = 0;
		
		int lastMinute = 0; // 남은 시간
		int lastSecond = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int win = Integer.parseInt(st.nextToken());
			String Time = st.nextToken();
			
			int minute = Integer.parseInt(Time.substring(0,2));
			int second = Integer.parseInt(Time.substring(3,5));
			
			int currentTime = minute * 60 + second;
			int lastTime = lastMinute * 60 + lastSecond;
			
			if(t1>t2) {
				t1Time += currentTime - lastTime;
			}else if(t1<t2) {
				t2Time += currentTime - lastTime;
			}
			
			if(win == 1) {
				t1++;
			}else {
				t2++;
			}
			
			lastMinute = minute;
			lastSecond = second;
		}
		
		
		// 마지막 득점 ~ 끝날때 까지
		int matchEndTime = 48 * 60; 
        int lastTime = lastMinute * 60 + lastSecond;
        if (t1 > t2) {
            t1Time += matchEndTime - lastTime;
        } else if (t2 > t1) {
            t2Time += matchEndTime - lastTime;
        }
        
        // 형식에 맞게 변환
        sb.append(String.format("%02d:%02d\n", t1Time / 60, t1Time % 60));
        sb.append(String.format("%02d:%02d", t2Time / 60, t2Time % 60));

        System.out.println(sb);
	}
}
