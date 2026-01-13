import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int zeroCnt = 0;
        int ans = 0;
        
        ArrayList<Integer> minusList = new ArrayList<>();
        ArrayList<Integer> plusList = new ArrayList<>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num > 1){
                plusList.add(num);
            }else if(num < 0){
                minusList.add(num);
            }else if(num == 0){
                zeroCnt++;
            }else if(num == 1){
                ans++;
            }
        }

        Collections.sort(minusList);
        Collections.sort(plusList);

        for(int i=0; i<minusList.size(); i+=2){
            if(i == minusList.size()-1){
                if(zeroCnt == 0){
                    ans += minusList.get(i);
                }
                break;
            }
            ans += minusList.get(i) * minusList.get(i+1);
        }

        for(int i=plusList.size()-1; i>=0; i-=2){
            if(i == 0){
                ans += plusList.remove(0);
                break;    
            }
            ans += plusList.remove(i) * plusList.remove(i-1);
        }
        System.out.println(ans);
    }
}