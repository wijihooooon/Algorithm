import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i=1; i<=N; i++){
            sum = i;
            String str = String.valueOf(i);
            
            for(int j=0; j<str.length(); j++){
                sum += str.charAt(j) - '0';
            }

            if(sum == N){
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}