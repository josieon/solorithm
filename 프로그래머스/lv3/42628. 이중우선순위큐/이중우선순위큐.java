import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> reverse = new PriorityQueue();
        PriorityQueue<Integer> natural = new PriorityQueue(Comparator.reverseOrder());
        for(String s : operations){
            String[] arr = s.split(" ");
            if(arr[0].matches("I")){
                natural.add(Integer.parseInt(arr[1]));
                reverse.add(Integer.parseInt(arr[1]));
            }
            else{
                if(natural.isEmpty())
                    continue;
                if(arr[1].matches("1")){
                    int tmp = natural.poll();
                    reverse.remove(tmp);
                }
                else{
                    int tmp = reverse.poll();
                    natural.remove(tmp);
                }
            }
        }
        int[] answer = new int[2];
        if(natural.size() > 0){
            answer[0] = natural.poll();
            answer[1] = reverse.poll();
        }
        return answer;
    }
}