import java.util.*;

class Solution {
    
    public static Set<String> set = new HashSet<>();
    public static int x = 5;
    public static int y = 5;
        
    public int solution(String dirs) {
        
        for(int i=0; i<dirs.length(); i++){
            char command = dirs.charAt(i);
            
            switch (command){
                case 'U':
                    move(-1, 0);
                    break;
                case 'D':
                    move(1, 0);
                    break;
                case 'R':
                    move(0, 1);
                    break;
                case 'L':
                    move(0, -1);
                    break;           
            }
        }
        
        return set.size() / 2;
    }
    
    public void move(int dx, int dy){
        int cx = x + dx;
        int cy = y + dy;
        
        if(cx < 0 || cy < 0 || cx > 10 || cy > 10) return;
        String go = x + "," + y + ":" + cx + "," + cy;
        String back = cx + "," + cy + ":" + x + "," + y;
        
        x = cx;
        y = cy;
        set.add(go);
        set.add(back);        
        
        return;
    }
}