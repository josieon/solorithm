class Solution {
    ///
    public int solution(int[] sides) {
        // int answer = Math.max(sides[0], sides[1]) - Math.abs(sides[0] - sides[1]);
        // answer += sides[0] + sides[1] - Math.max(sides[0], sides[1]) - 1;
        int answer = sides[0] + sides[1] - Math.abs(sides[0] - sides[1]) - 1;
        return answer;
    }
}