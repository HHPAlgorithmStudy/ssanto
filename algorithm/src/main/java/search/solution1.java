package search;

public class solution1 {
    public int solution(int[][] sizes) {
        int maxWidth = 0;  // 가장 큰 가로 길이
        int maxHeight = 0; // 가장 큰 세로 길이

        for (int[] size : sizes) {
            int w = Math.max(size[0], size[1]); // 가로와 세로 중 큰 값
            int h = Math.min(size[0], size[1]); // 가로와 세로 중 작은 값

            maxWidth = Math.max(maxWidth, w);
            maxHeight = Math.max(maxHeight, h);
        }

        return maxWidth * maxHeight;
    }
}
