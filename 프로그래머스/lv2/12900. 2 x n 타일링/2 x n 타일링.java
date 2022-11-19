class Solution {
    public int solution(int n) {
        int[] fib = new int[60001];
        fib[0] = 1;
        fib[1] = 1;
        for(int i = 2; i <= n; i++)
            fib[i] = (fib[i-1] + fib[i-2]) % 1_000_000_007;
        return fib[n];
    }
}