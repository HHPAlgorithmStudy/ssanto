package queue;

import java.util.ArrayList;
import java.util.List;

public class solution1 {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int n = progresses.length;

        int daysNeeded = (int) Math.ceil((100.0 - progresses[0]) / speeds[0]);
        int count = 1;

        for (int i = 1; i < n; i++) {
            int currentDaysNeeded = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);

            if (currentDaysNeeded <= daysNeeded) {
                count++;
            } else {
                result.add(count);
                daysNeeded = currentDaysNeeded;
                count = 1;
            }
        }

        result.add(count);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }


}
