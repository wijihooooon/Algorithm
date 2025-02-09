import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[10001];
        int sum = 0;
        arr[0] = 1;
        for (int i = 1; i <= 10000; i++) {
            sum = i;
            for(int j=0; j<Integer.toString(i).length(); j++){
                sum += Integer.toString(i).charAt(j) - '0';
            }
            if(sum >10000) continue;
            arr[sum]++;
        }

        for(int i=1; i<arr.length; i++){
            if(arr[i] == 0){
                System.out.println(i);
            }
        }

    }
}
