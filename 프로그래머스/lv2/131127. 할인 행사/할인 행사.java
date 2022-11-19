import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map = new HashMap();
        for(int i = 0; i < number.length; i++)
            map.put(want[i], number[i]);
        int answer = 0;
        for(int i = 0; i <= discount.length - 10; i++){
            String[] tmp = Arrays.copyOfRange(discount, i, i+10);
            HashMap<String, Integer> dump = new HashMap();
            for(String s : tmp)
                dump.put(s, dump.getOrDefault(s, 0) + 1);
            // System.out.println(dump.toString());
            if(dump.size() != map.size())
                continue;
            if(dump.entrySet().equals(map.entrySet()))
                answer++;
        }
        return answer;
    }
}