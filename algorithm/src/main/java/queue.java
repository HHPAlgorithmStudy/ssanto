import java.util.ArrayList;

public class queue {

    public int[] solution(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();

        // 배열이 비어있지 않다면 첫 번째 숫자 추가
        result.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                result.add(arr[i]);  // 중복되지 않은 숫자를 추가
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

}
