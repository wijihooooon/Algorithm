import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0) return cities.length * 5;

        int answer = 0;

        HashMap<String, Integer> record = new HashMap();

        for(int i=0; i<cities.length; i++){
            String city = cities[i].toLowerCase();
            if(record.containsKey(city)){
                answer += 1;
                record.put(city, i);
            }else{

                if(record.size() >= cacheSize){

                    int oldest = Integer.MAX_VALUE;
                    String deleteCity = "";

                    for(Map.Entry<String, Integer> re : record.entrySet()){
                        if(re.getValue() < oldest){
                            oldest = re.getValue();
                            deleteCity = re.getKey();
                        }
                    }
                    record.remove(deleteCity);
                }
                record.put(city,i);
                answer += 5;
            }
        }

        return answer;
    }
}