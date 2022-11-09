import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] arrived = new int[N+1];
        int[] stopped = new int[N+2];
        for(int i : stages){
            stopped[i]++;
        }
        arrived[N] = stopped[N+1] + stopped[N];
        for(int i = N-1; i >= 1; i--)
            arrived[i] = stopped[i] + arrived[i+1];
        HashMap<Integer, Double> map = new HashMap();
        for(int i = 1; i < arrived.length; i++){
            if(arrived[i] == 0 || stopped[i] == 0)
                map.put(i, 0.0);
            else
                map.put(i, (double)stopped[i]/arrived[i]);
        }
        List<Integer> list = new ArrayList(map.keySet());
        Collections.sort(list, (o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}