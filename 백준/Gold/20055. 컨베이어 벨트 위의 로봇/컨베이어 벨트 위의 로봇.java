import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 컨베이어 밸트 개수
        int K = Integer.parseInt(st.nextToken()); // 내구도 0짜리 개수

        ArrayList<conveyorBelt> upBelt = new ArrayList<>();
        ArrayList<conveyorBelt> downBelt = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            upBelt.add(new conveyorBelt(Integer.parseInt(st.nextToken())));
        }

        for(int i=N; i<2*N; i++){
            downBelt.add(new conveyorBelt(Integer.parseInt(st.nextToken())));
        }

        int count = 0; // 내구도가 0인 벨트 새는 변수
        int step = 1; // 단계 새는 변수

        Queue<Integer> q = new ArrayDeque<>(); // 로봇의 위치 저장용 Queue

        while(true){
            // 회전
            upBelt.add(0, downBelt.remove(downBelt.size() -1));
            downBelt.add(0, upBelt.remove(upBelt.size() - 1));

            // 로봇 이동
            if(!q.isEmpty()){
                int size = q.size();
                for(int i=0; i<size; i++){
                    int number = q.poll() + 1; // 컨베이어 벨트 이동 고려

                    // 로봇이 내리는 곳일 경우
                    if(number == N-1){
                        upBelt.get(number).isRobot = false;
                        continue;
                    }

                    // 로봇이 있거나 내구도가 0인 경우
                    if(upBelt.get(number+1).durability == 0 || upBelt.get(number+1).isRobot){
                        q.add(number);
                        continue;
                    }

                    // 다음 벨트 내구도 -1, 0이면 count++;
                    upBelt.get(number+1).durability--;
                    if(upBelt.get(number+1).durability == 0) count++;

                    // 이동 했으므로 현재위치에 있는 로봇 false
                    upBelt.get(number).isRobot = false;
                    // 이동한 곳이 내리는 곳이면 내림 아니면 이동한 곳 로봇 true
                    if(number + 1 == N-1) continue;
                    upBelt.get(number+1).isRobot = true;

                    q.add(number+1);
                }
            }
            // 3. 로봇 추가
            if(upBelt.get(0).durability != 0){
                upBelt.get(0).durability--;
                if(upBelt.get(0).durability == 0) count++;
                upBelt.get(0).isRobot = true;
                q.add(0);
            }

            // 4. 내구도 0이 K개 이상인지 확인
            if(count >= K){
                System.out.println(step);
                break;
            }

            // 단계 증가
            step++;
        }
    }
    private static class conveyorBelt {
        int durability;
        boolean isRobot = false;

        // 처음에 벨트 생성할때
        conveyorBelt(int durability){
            this.durability = durability;
        }
    }
}
/*
    풀이 아이디어
    두개의 덱으로 위 아래 컨베이어 벨트 표현 ? -> 로봇도 움직이기에 불가능
    두개의 LinkedList(로봇이 움직이기 때문에 ArrayList 유리할듯)로 위 아래를 나타내고 컨베이어 벨트 상태를 나타내는
    클래스를 만들어서 내구도 로봇 유무 나타냄
    내구도가 0인 컨베이어 벨트를 새는 count 변수 하나 생성
    1~4가 한 단계이므로 단계 세는 step 변수 필요
    로봇위치 저장하는 q int 타입

    대략적인 구상
    while{
    1. 컨베이어 벨트 회전(컨베이어벨트 앞뒤 삽입 삭제)
    2. 로봇의 현재 위치는 벨트 회전으로 인해 +1된값 고려
        로봇이 있고
        현재 위치가 탈출 위치면 탈출
        아니면 로봇의 위치 +1 만약 다음칸의 내구도가 0이거나 로봇이있으면 못감
          갈 수 있다면 해당 칸 내구도 -1 내구도가 0이면 count++;
    3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 로봇 올림
    4. K개 이상이아니면 step++
    }
 */