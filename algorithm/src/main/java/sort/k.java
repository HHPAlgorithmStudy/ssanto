package sort;

import java.util.Arrays;

public class k {
        public int[] solution(int[] array, int[][] commands) {

            int[] answer = new int[commands.length];

            // 배열을 순회하면서 정렬
            for (int index = 0; index < commands.length; index++) {

                int i = commands[index][0];  // 자를 시작 위치
                int j = commands[index][1];  // 자를 끝 위치
                int k = commands[index][2];  // 찾고 싶은 위치

                int[] slicedArray = Arrays.copyOfRange(array, i - 1, j);

                // 자른 배열을 정렬
                Arrays.sort(slicedArray);

                // 0부터 시작하므로 k-1을 사용
                answer[index] = slicedArray[k - 1];
            }

            return answer;
        }

}
