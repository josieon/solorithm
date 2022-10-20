class Solution {
    public int solution(int chicken) {
        int tmp = chicken % 10;
        int answer = chicken / 10;
        tmp += answer;
        while(tmp >= 10){
            answer += (tmp/10);
            tmp = tmp/10 + tmp%10;
        }
        return answer;
    }
}