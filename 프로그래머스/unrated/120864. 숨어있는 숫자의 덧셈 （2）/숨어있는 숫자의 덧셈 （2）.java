// split
//  장점: 정규 표현식 사용 가능
//  단점: 느리다(정규표현식)
// StringTokenizer
//  장점: 빠르다
//  단점: 정규 표현식 사용 불가, 단순한 문자로만 쪼갤 수 있다.
import java.util.*;
class Solution {
    public int solution(String my_string) {
        String[] arr = my_string.split("[a-z, A-Z]");
        int answer = 0;
        for(String s : arr)
            if(s.length() > 0)
                answer += Integer.parseInt(s);
        return answer;
    }
}