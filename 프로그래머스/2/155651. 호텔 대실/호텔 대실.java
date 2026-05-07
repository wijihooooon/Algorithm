import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int order = book_time.length;
        
        ArrayList<Room> roomList = new ArrayList<>();
        
        Arrays.sort(book_time, (a, b)-> {
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        for(int i=0; i<order; i++){
            String[] I = book_time[i][0].split(":");
            String[] O = book_time[i][1].split(":");
            
            int in = Integer.parseInt(I[0]) * 60 + Integer.parseInt(I[1]);
            int out = Integer.parseInt(O[0]) * 60 + Integer.parseInt(O[1]);
            
            Room room = new Room(in, out);
            
            
            boolean noRoom = true;
            
            for(int j=0; j<roomList.size(); j++){
                int roomIn = roomList.get(j).in;
                int roomOut = roomList.get(j).out;
                
                if(roomOut + 10 <= in){
                    roomList.get(j).out = out;
                    noRoom = false;
                    break;
                }
            }
            
            if(noRoom) {
                roomList.add(room);
                answer++;
            }
        }
        
        return answer;
    }
    
    class Room{
        int in;
        int out;
        
        public Room(int in, int out){
            this.in = in;
            this.out = out;
        }
    }
}