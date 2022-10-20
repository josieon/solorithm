class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int i = Math.abs(sides[0] - sides[1]) + 1;
        for(; i <= Math.max(sides[0], sides[1]); i++)
            answer++;
        for(; i < sides[0] + sides[1]; i++)
            answer++;
        return answer;
    }
}