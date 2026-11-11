import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        // #을 일반화 ex) C# -> c
        m = normalize(m);
        
        // 재생시간 및 배열 순으로 정렬
        Arrays.sort(musicinfos, (a, b) -> {
            StringTokenizer stA = new StringTokenizer(a, ",");
            StringTokenizer stB = new StringTokenizer(b, ",");

            int aT = timeCal(stA.nextToken(), stA.nextToken());
            int bT = timeCal(stB.nextToken(), stB.nextToken());

            return Integer.compare(bT, aT);
        });

        // m을 포함하고 있는지 점검 있으면 즉시 return
        for(int i=0; i<musicinfos.length; i++){
            StringTokenizer st = new StringTokenizer(musicinfos[i], ",");
            int playTime = timeCal(st.nextToken(), st.nextToken());
            String name = st.nextToken();
            String melody = normalize(st.nextToken());
            
            String akbo = "";
            for(int j=0; j<playTime; j++){
                akbo += melody.charAt(j % melody.length());
                if(j+1 != playTime && melody.charAt((j+1) % melody.length()) == '#'){
                    akbo += "#";
                    j++;
                }
            }
            
            if(akbo.contains(m)) return name;
        }

        return "(None)";
    }
    
    public String normalize(String str) {
    StringBuilder normalStr = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
        char note = str.charAt(i);

        if (i + 1 < str.length() && str.charAt(i + 1) == '#') {
            normalStr.append(Character.toLowerCase(note));
            i++;
        } else {
            normalStr.append(note);
        }
    }

    return normalStr.toString();
}

    public int timeCal(String timeS, String timeE) {
        int sH = Integer.parseInt(timeS.substring(0, 2));
        int sM = Integer.parseInt(timeS.substring(3, 5));
        int eH = Integer.parseInt(timeE.substring(0, 2));
        int eM = Integer.parseInt(timeE.substring(3, 5));

        return (eH * 60 + eM) - (sH * 60 + sM);
    }
}