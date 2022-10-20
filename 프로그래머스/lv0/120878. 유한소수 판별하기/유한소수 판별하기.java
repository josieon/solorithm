class Solution {
    public int solution(int a, int b) {
        int B = b;
        B /= gcd(a, b);
        while(true){
            if(B % 2 == 0){
                B /= 2;
                continue;
            }
            else if(B % 5 == 0){
                B /= 5;
                continue;
            }
            else{
                if(B == 1)
                    return 1;
                else
                    return 2;
            }
        }
    }
    public int gcd(int A, int B){
        if(B == 0)
            return A;
        return gcd(B, A%B);
    }
}