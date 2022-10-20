class Solution {
    public int solution(int[][] dots) {
        int widthMax = Math.max(dots[0][0], dots[1][0]);
        int widthMin = Math.min(dots[0][0], dots[1][0]);
        widthMax = Math.max(widthMax, dots[2][0]);
        widthMin = Math.min(widthMin, dots[2][0]);
        int heightMax = Math.max(dots[0][1], dots[1][1]);
        int heightMin = Math.min(dots[0][1], dots[1][1]);
        heightMax = Math.max(heightMax, dots[2][1]);
        heightMin = Math.min(heightMin, dots[2][1]);
        return (widthMax - widthMin) * (heightMax - heightMin);
    }
}