class Solution {
    public int solution(int n) {
        int num1 = 0;
        for(char c : Integer.toBinaryString(n).toCharArray())
            if(c == '1')
                num1++;
        int cnt;
        for(int i = n + 1; ; i++){
            cnt = 0;
            for(char c : Integer.toBinaryString(i).toCharArray())
                if(c == '1')
                    cnt++;
            if(cnt == num1)
                return i;
        }
    }
}