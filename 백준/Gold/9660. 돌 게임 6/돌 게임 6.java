import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        String[] dol = new String[8];
        
        dol[0] = "CY";
        dol[1] = "SK";
        dol[2] = "CY";
        dol[3] = "SK";
        dol[4] = "SK";
        dol[5] = "SK";
        dol[6] = "SK";

        System.out.println(dol[(int) (N % 7)]);
    }
}