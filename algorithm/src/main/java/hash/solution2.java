package hash;

import java.util.HashMap;

public class solution2 {

    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesMap = new HashMap<>();

        for (String[] cloth : clothes) {
            String type = cloth[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }

        int answer = 1;
        for (int count : clothesMap.values()) {
            answer *= (count + 1);
        }

        return answer - 1;
    }
}
