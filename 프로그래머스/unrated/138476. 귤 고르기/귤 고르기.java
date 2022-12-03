import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> hash = new HashMap();
        for(int tanger : tangerine)
            hash.put(tanger, hash.getOrDefault(tanger, 0) + 1);
        List<Map.Entry<Integer, Integer>> list = new LinkedList(hash.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                return e2.getValue() - e1.getValue();
            }
        });
        // System.out.println(list.toString());
        int answer = 0;
        for(Map.Entry<Integer, Integer> entry : list){
            if(k <= 0)
                break;
            k -= entry.getValue();
            answer++;
        }
        return answer;
    }
}