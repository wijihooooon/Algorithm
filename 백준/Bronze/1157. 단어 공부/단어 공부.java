import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int alpa[] = new int[26];
		
		for(int i=0; i<s.length(); i++) {
			char a = s.charAt(i);
			if(a >= 'a' && a <= 'z') { // 소문자~
				alpa[a - 'a']++;
			}else if(a >= 'A' && a <= 'Z') { // 대문자~
				alpa[a - 'A']++;
			}else { // 너는 중문자~ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
				System.out.println("중문자 입니다. 깔깔깔");
			}
		}
		
		int max = 0;
		char maxchar = '?';
		
		for(int i=0; i<26; i++) {
			if(alpa[i] > max) {
				max = alpa[i];
				maxchar = (char) (i + 'A');
			}else if(max != 0 && max == alpa[i]) {
				maxchar = '?';
			}
		}

		System.out.println(maxchar);
		
	}

}
