import java.util.*;
class Solution {
    // 최빈값 알고리즘
    public int solution(int[] array){
        int[] arr = new int[1000];
        for(int i : array)
            arr[i]++;
        int answer = -1;
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
                answer = i;
            }
            else if(max == arr[i])
                answer = -1;       
        }
        return answer;
    }
    // public int solution(int[] array) {
    //     HashMap<Integer, Integer> map = new HashMap();
    //     for(int i : array)
    //         map.put(i, map.getOrDefault(i, 0) + 1);
    //     List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
    //     list.sort(new Comparator<Map.Entry<Integer, Integer>>(){
    //         @Override
    //         public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
    //             return o2.getValue() - o1.getValue();
    //         }
    //     });
    //     if(list.size() > 1 && list.get(0).getValue() == list.get(1).getValue())
    //         return -1;
    //     else
    //         return list.get(0).getKey();
    // }
}