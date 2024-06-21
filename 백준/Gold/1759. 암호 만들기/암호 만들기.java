import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int L, C;
	
	public static char arr[];
	public static char password[];
	
	public static int num[];
	public static boolean visited[];
	
	public static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		L = Integer.parseInt(st.nextToken()); // L개로 이루어진 암호
		C = Integer.parseInt(st.nextToken()); // C개의 알파벳
		
		arr = new char[C+1];
		
		num = new int[C+1];
		visited = new boolean[C+1];
		
		password = br.readLine().replaceAll("\\s", "").toCharArray(); // br.readLine()은 10개씩 가져오기에 빈칸을 replaceAll("//s", "")로 삭제
		
		Arrays.sort(password);
		
		makePW(0);
		
		for(int i=0; i<list.size(); i++) {
			String s = list.get(i);
			
			int count1 = 0;
			int count2 = 0;
			
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o' || s.charAt(j) == 'u' ) {
					count1++;
				}else {
					count2++;
				}
				
				if(count1 >=1 && count2 >=2) {
					sb.append(s).append("\n");
					break;
				}
			}
		}
		
		System.out.println(sb);
		
	}

	private static void makePW(int cnt) {
		if(cnt == L) {
			String s = "";
			for(int i=0; i<cnt; i++) {
				s += arr[i];
			}
			list.add(s);
			return;
		}
		
		int start = (cnt == 0) ? 0 : num[cnt - 1] + 1;
		
		for(int i = start; i<C; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[cnt] = password[i];
				num[cnt] = i; // 인덱스 저장용
				makePW(cnt+1);
				visited[i] = false;
			}
		}
		
	}

}
