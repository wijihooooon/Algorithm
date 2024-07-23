import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[][] dice) {
        int n = dice.length;
        boolean[] choiceTheDice = new boolean[n];
        max = 0;
        bestCombination = new int[n / 2];
        diceChoiceCombi(0, 0, dice, choiceTheDice);
        return bestCombination;
    }
    public static ArrayList<Integer> listA = new ArrayList<>();
    public static ArrayList<Integer> listB = new ArrayList<>();
    public static ArrayList<Integer> sumA = new ArrayList<>();
    public static ArrayList<Integer> sumB = new ArrayList<>();

    public static int max = 0;
    public static int[] bestCombination;

    private static void diceChoiceCombi(int cnt, int start, int[][] dice, boolean[] choiceTheDice) {
        if (cnt == dice.length / 2) {
            listA.clear();
            listB.clear();
            for (int i = 0; i < dice.length; i++) {
                if (choiceTheDice[i]) {
                    listA.add(i);
                } else {
                    listB.add(i);
                }
            }

            sumA.clear();
            sumB.clear();
            dicesum(listA, sumA, dice, 0, 0);
            dicesum(listB, sumB, dice, 0, 0);

            Collections.sort(sumA);
            Collections.sort(sumB);

            int temp = max;
            max = Math.max(binarySearch(sumA, sumB), max);
            if (max != temp) { // 변경되면
                for (int i = 0; i < listA.size(); i++) {
                    bestCombination[i] = listA.get(i) + 1; // 인덱스를 1부터 시작하도록 수정
                }
            }

            return;
        }

        for (int i = start; i < dice.length; i++) {
            if (!choiceTheDice[i]) {
                choiceTheDice[i] = true;
                diceChoiceCombi(cnt + 1, i + 1, dice, choiceTheDice);
                choiceTheDice[i] = false;
            }
        }
    }

    private static void dicesum(ArrayList<Integer> list, ArrayList<Integer> sum, int[][] dice, int cnt, int hap) {
        if (cnt == list.size()) {
            sum.add(hap);
            return;
        }

        int idx = list.get(cnt);
        for (int i = 0; i < 6; i++) {
            dicesum(list, sum, dice, cnt + 1, hap + dice[idx][i]);
        }
    }

    private static int binarySearch(ArrayList<Integer> sumA, ArrayList<Integer> sumB) {
        int sum = 0;
        for (int i = 0; i < sumA.size(); i++) {
            int score = sumA.get(i); // 비교할 값!

            int start = 0;
            int end = sumB.size() - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (sumB.get(mid) < score) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            sum += start;
        }
        return sum;
    }
}