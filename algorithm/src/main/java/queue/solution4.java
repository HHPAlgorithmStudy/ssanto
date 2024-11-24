package queue;

//      문제 설명
//        초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
//
//        제한사항
//        prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
//        prices의 길이는 2 이상 100,000 이하입니다.
//        입출력 예
//        prices	return
//        [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
//        입출력 예 설명
//        1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
//        2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
//        3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
//        4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
//        5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.


public class solution4 {

    public int[] solution(int[] prices) {
        int n = prices.length;  // 가격 배열의 길이
        int[] answer = new int[n];  // 결과를 저장할 배열

        // 1. 각 시간의 가격이 유지된 시간 계산
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] < prices[i]) {
                    // 가격이 떨어지면 멈추기
                    answer[i] = j - i;
                    break;
                }
                // 마지막까지 떨어지지 않으면 유지 시간을 추가
                answer[i] = j - i;
            }
        }

        return answer;
    }
}


// 다른 사람 풀이
class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }
}