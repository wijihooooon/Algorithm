import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int sum = i;
            int num = i;

            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if(sum == N){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
