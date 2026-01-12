import java.util.*;
import java.io.*;

public class Main{

    public static String founder;
    public static HashMap<String, Person> jokbo;
    public static Stack<String> stack;
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        jokbo = new HashMap<>();
        founder = br.readLine();
 
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String father = st.nextToken();
            String mother = st.nextToken();

            jokbo.put(child, new Person(father, mother));
        }

        String answer = "";
        double ans = -1.0;

        for(int i=0; i<M; i++){
            String str = br.readLine();
            double blood = updateBlood(str);

            if(blood > ans){
                answer = str;
                ans = blood;
            }
        }

        System.out.println(answer);

    }

    public static class Person{
        String father;
        String mother;
        Double blood;

        public Person(String father, String mother){
            this.father = father;
            this.mother = mother;
            this.blood = null;
        }
    }

    public static double updateBlood(String name){
        if(name == null) return 0.0;
        if(name.equals(founder)) return 1.0;

        Person person = jokbo.get(name);
        if(person == null) return 0.0;
        if(person.blood != null) return person.blood;

        double fb = updateBlood(person.father);
        double mb = updateBlood(person.mother);
        person.blood = (fb + mb) / 2.0;
        return person.blood;
    }
}