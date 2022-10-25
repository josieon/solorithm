import java.util.*;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> answer = new HashSet();
        for(int size = 1; size < elements.length; size++){
            for(int start = 0; start < elements.length; start++){
                int sum = 0;
                for(int count = 0; count < size; count++){
                    sum += start + count >= elements.length ? elements[(start+count)%elements.length] : elements[start+count];
                }
                answer.add(sum);
            }
        }
        return answer.size() + 1;
    }
}