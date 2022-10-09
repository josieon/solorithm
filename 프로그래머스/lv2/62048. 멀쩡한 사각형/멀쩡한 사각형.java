class Solution {
    public long solution(int w, int h) {
        long answer = (long)w * h;
        int gcd = gcd(w, h);
        int width = w / gcd;
        int height = h / gcd;
        answer = answer - (long)(gcd * (width + height - 1));
        return answer;
    }
    public static int gcd(int A, int B){
        if(B == 0)
            return A;
        else
            return gcd(B, A % B);
    }
}