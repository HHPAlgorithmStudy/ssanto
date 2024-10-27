package greedy;

import java.util.Arrays;

public class solution1 {

    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        Arrays.fill(students, 1);

        // 체육복을 도난당한 학생의 체육복 수를 0으로 설정
        for (int l : lost) {
            students[l - 1]--;
        }

        // 여벌 체육복을 가진 학생의 체육복 수를 2로 설정
        for (int r : reserve) {
            students[r - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (students[i] == 0) { // 체육복이 없는 학생일 경우

                if (i > 0 && students[i - 1] == 2) {
                    students[i] = 1;
                    students[i - 1] = 1;
                }
                else if (i < n - 1 && students[i + 1] == 2) {
                    students[i] = 1;
                    students[i + 1] = 1;
                }
            }
        }

        int count = 0;
        for (int s : students) {
            if (s > 0) {
                count++;
            }
        }

        return count;
    }
}
