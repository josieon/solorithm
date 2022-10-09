class Solution {
    public int solution(int n) {
        return func(n);
    }
    public int func(int n){
        int cnt = 0;
        int i = 1;
        while(n > 0){
            if(n % i == 0)
                cnt++;
            n -= i++;
        }
        return cnt;
    }
}