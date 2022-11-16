class Solution {
    public int solution(String word) {
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        int[] con = {781, 156, 31, 6, 1};
        int answer = 0;
        for(int i = 0; i < word.length(); i++){
            int j = 0;
            for(; j < vowels.length; j++)
                if(vowels[j] == word.charAt(i))
                    break;
            answer += 1 + con[i] * j;
        }
        return answer;
    }
}