package heap;

import java.util.PriorityQueue;

public class solution1 {

    /**
    문제 설명
    매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
    모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.

    섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
    Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
    모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

    제한 사항
    scoville의 길이는 2 이상 1,000,000 이하입니다.
            K는 0 이상 1,000,000,000 이하입니다.
    scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
    모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
            입출력 예
    scoville	K	return
            [1, 2, 3, 9, 10, 12]	7	2
    입출력 예 설명
    스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
    새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
    가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]

    스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
    새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
    가진 음식의 스코빌 지수 = [13, 9, 10, 12]

    모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.

    */

    public class Solution {
        public int solution(int[] scoville, int K) {

            PriorityQueue<Integer> heap = new PriorityQueue<>();

            // 모든 스코빌 지수를 큐에 추가
            for (int s : scoville) {
                heap.add(s);
            }

            int mixCount = 0; // 섞은 횟수

            // 스코빌 지수가 K 이상이 될 때까지 반복
            while (heap.size() > 1) { // 큐에 음식이 2개 이상 있을 때만 섞을 수 있음
                if (heap.peek() >= K) { // 가장 작은 값이 K 이상이면 종료
                    return mixCount;
                }

                // 가장 작은 두 값을 꺼내 섞기
                int first = heap.poll(); // 가장 작은 값
                int second = heap.poll(); // 두 번째로 작은 값
                int newScoville = first + (second * 2); // 새로운 음식의 스코빌 지수 계산
                heap.add(newScoville); // 섞은 결과를 다시 큐에 추가
                mixCount++; // 섞은 횟수 증가
            }

            // 큐에 값이 하나 남았을 때도 K 미만이면 -1 반환  <- null point 생길수 있다...?
            return heap.peek() >= K ? mixCount : -1;
        }
    }





    //다른사람 풀이
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++)
            q.add(scoville[i]);

        int count = 0;
        while(q.size() > 1 && q.peek() < K){
            int weakHot = q.poll();
            int secondWeakHot = q.poll();

            int mixHot = weakHot + (secondWeakHot * 2);
            q.add(mixHot);
            count++;
        }

        if(q.size() <= 1 && q.peek() < K)
            count = -1;

        return count;
    }
}
