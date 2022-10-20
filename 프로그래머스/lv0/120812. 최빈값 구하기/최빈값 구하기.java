import java.util.*;
class Solution {
    public int solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i : array)
            map.put(i, map.getOrDefault(i, 0) + 1);
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
                return o2.getValue() - o1.getValue();
            }
        });
        if(list.size() > 1 && list.get(0).getValue() == list.get(1).getValue())
            return -1;
        else
            return list.get(0).getKey();
    }
}