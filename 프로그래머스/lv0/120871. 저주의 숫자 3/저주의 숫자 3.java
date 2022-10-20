class Solution {
    public int solution(int n) {
        int answer = 1;
        for(int i = 1; i <= n; i++, answer++){
            while(answer % 3 == 0 || Integer.toString(answer).contains("3"))
                answer++;
            // System.out.println(i + "\t" + answer);
        }
        return answer - 1;
    }
}