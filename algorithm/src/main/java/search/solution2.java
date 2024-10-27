package search;

import java.util.ArrayList;

public class solution2 {
    public int[] solution(int[] answers) {

        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int score1 = 0, score2 = 0, score3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) score1++; // 1번 수포자의 정답 비교
            if (answers[i] == pattern2[i % pattern2.length]) score2++; // 2번 수포자의 정답 비교
            if (answers[i] == pattern3[i % pattern3.length]) score3++; // 3번 수포자의 정답 비교
        }

        // 가장 높은 점수를 찾기
        int maxScore = Math.max(score1, Math.max(score2, score3));

        ArrayList<Integer> topScorers = new ArrayList<>();
        if (score1 == maxScore) topScorers.add(1); // 1번 수포자가 최고 점수면 추가
        if (score2 == maxScore) topScorers.add(2); // 2번 수포자가 최고 점수면 추가
        if (score3 == maxScore) topScorers.add(3); // 3번 수포자가 최고 점수면 추가

        return topScorers.stream().mapToInt(Integer::intValue).toArray();
    }

}
