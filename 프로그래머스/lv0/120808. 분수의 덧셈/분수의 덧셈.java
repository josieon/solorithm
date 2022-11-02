class Solution {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int num = num1 * num2 / gcd(num1, num2);
        int denum = denum1 * num/num1 + denum2 * num/num2;
        return new int[] {denum, num};
    }
    public int gcd(int A, int B){
        if(B == 0)
            return A;
        return gcd(B, A % B);
    }
}