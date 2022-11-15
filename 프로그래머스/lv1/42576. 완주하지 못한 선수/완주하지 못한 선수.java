import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap();
        for(String str : completion)
            map.put(str, map.getOrDefault(str, 0) + 1);
        // System.out.println(map.toString());
        for(String str : participant){
            int val = map.getOrDefault(str, 0);
            if(val == 0)
                return str;
            map.put(str, val-1);
        }
        return null;
    }
}