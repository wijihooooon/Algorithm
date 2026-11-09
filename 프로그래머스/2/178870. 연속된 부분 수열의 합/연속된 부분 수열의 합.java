class Solution {
    public int[] solution(int[] sequence, int k) {

        int[] answer = new int[2];

        int start = 0;
        int end = 0;
        int sum = sequence[0];
        int minLength = Integer.MAX_VALUE;

        while (start < sequence.length && end < sequence.length) {
            // 합이 k이고, 기존에 찾은 구간보다 짧으면 정답 갱신
            // 길이가 같으면 갱신하지 않아 시작 인덱스가 작은 구간 유지
            if (sum == k && end - start < minLength) {
                minLength = end - start;
                answer[0] = start;
                answer[1] = end;

                // 원소가 하나인 구간은 더 짧아질 수 없으므로 즉시 반환
                if (minLength == 0) {
                    return answer;
                }
            }

            if (sum >= k) {
                // 합이 k 이상이면 왼쪽 원소를 빼고 시작 인덱스 이동
                sum -= sequence[start++];
            } else {
                // 합이 k보다 작으면 끝 인덱스를 오른쪽으로 이동
                end++;

                // 배열 범위 안에 있을 때만 새 원소를 합에 추가
                if (end < sequence.length) {
                    sum += sequence[end];
                }
            }
        }

        return answer;
    }
}