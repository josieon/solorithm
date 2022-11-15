class Solution {
    public int solution(int a, int b, int n) {
        if(n < a)
            return 0;
        int answer = n / a;
        return answer * b + solution(a, b, answer * b + n % a);
    }
}