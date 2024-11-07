import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
// 그룹단어 ->  ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin
// 그룹단어 x -> aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
			
		int alpa[]; // a~z 26
		int ans = N;
		for(int i=0; i<N; i++) {
			alpa = new int[26];
			
			String str = br.readLine();
			alpa[str.charAt(0)-'a']++;
			
			for(int j=1; j<str.length(); j++) {
				if(str.charAt(j-1)-'a' != str.charAt(j)-'a' && alpa[str.charAt(j)-'a'] >=1) {
					ans--;
					break;
				}
				alpa[str.charAt(j)-'a']++;
			}
		}
		
	System.out.println(ans);
	}
}
