class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int numX = 0, others = 0;
        char x = 'a';
        for(char c : s.toCharArray()){
            if(numX == 0)
                x = c;
            if(x == c)
                numX++;
            else
                others++;
            if(numX == others){
                answer++;
                numX = others = 0;
            }
        }
        if(numX != 0 || others != 0)
            answer++;
        
        return answer;
    }
}