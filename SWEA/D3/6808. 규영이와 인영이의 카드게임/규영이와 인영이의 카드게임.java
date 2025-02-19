import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static int win, lose;
    public static boolean[] visited;
    public static int[] card1;
    public static ArrayList<Integer> card2;
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        HashSet<Integer> set;
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
             
            win = 0;
            lose = 0;
             
            set = new HashSet<>();
            visited = new boolean[9];
            card1 = new int[9];
            card2 = new ArrayList<>();
             
            for(int i=0; i<9; i++) {
                card1[i] = Integer.parseInt(st.nextToken());
                set.add(card1[i]);
            }
             
            for(int i=1; i<=18; i++) {
                if(set.contains(i)) continue;
                card2.add(i);
            }
             
            perm(0, 0 ,0);
             
            sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);
    }
 
    private static void perm(int cnt, int min, int gyu) {
        if(cnt == 9) {
            shobu(min, gyu);
            return;
        }
         
        for(int i=0; i<9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int score = card1[i] + card2.get(cnt); 
                if(card1[i] > card2.get(cnt)) {
                    perm(cnt+1, min+score, gyu);
                }else if(card1[i]<card2.get(cnt)) {
                    perm(cnt+1, min, gyu+score);
                }
                visited[i] = false;
            }
        }
    }
 
    private static void shobu(int min, int gyu) {
        if(min > gyu) {
            win++;
        }else {
            lose++;
        }
    }
}