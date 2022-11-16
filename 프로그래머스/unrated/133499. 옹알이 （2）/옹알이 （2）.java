import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        for(int i = 0 ; i < babbling.length; i++){
            babbling[i] = babbling[i].replaceAll("ayaaya", "-");
            babbling[i] = babbling[i].replaceAll("yeye", "-");
            babbling[i] = babbling[i].replaceAll("woowoo", "-");
            babbling[i] = babbling[i].replaceAll("mama", "-");
            babbling[i] = babbling[i].replaceAll("aya", ".");
            babbling[i] = babbling[i].replaceAll("ye", ".");
            babbling[i] = babbling[i].replaceAll("woo", ".");
            babbling[i] = babbling[i].replaceAll("ma", ".");
            babbling[i] = babbling[i].replaceAll("\\.", "");
        }
        int answer = 0;
        for(String s : babbling){
            if(s.length() == 0)
                answer++;
        }
        System.out.println(Arrays.toString(babbling));
        return answer;
    }
}