class Solution {
    static int[] arr = new int[100001];
    public int solution(int n) {
        initialize();
        return arr[n];
    }
    public static void initialize(){
        arr[1] = 1;
        for(int i = 2; i < 100001; i++)
            arr[i] = (arr[i-1] % 1234567 + arr[i-2] % 1234567) % 1234567;
    }
}