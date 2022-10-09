import java.util.*;
class Solution {
        public static int[] solution(int[] fees, String[] records){
        HashMap<Integer, Integer> answerMap = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(String str : records){
            StringTokenizer st = new StringTokenizer(str);
            String time = st.nextToken();
            time = time.substring(0, 2).concat(time.substring(3, 5));
            int number = Integer.parseInt(st.nextToken());
            String way = st.nextToken();
            if(way.matches("IN"))
                map.put(number,Integer.parseInt(time));
            else{
                int timeUsed = map.get(number);
                timeUsed = timeUsed/100*60 + timeUsed%100;
                int timeOut = Integer.parseInt(time);
                timeOut = timeOut/100*60 + timeOut%100;
                timeUsed = timeOut - timeUsed;
                answerMap.put(number, answerMap.getOrDefault(number, 0) + timeUsed); 
                // System.out.println(answerMap.toString());
                map.remove(number);
            }
        }
        if(!map.isEmpty()){
            Iterator<Integer> iter = map.keySet().iterator();
            while(iter.hasNext()){
                int number = iter.next();
                int timeUsed = map.get(number);
                timeUsed = 2359 - timeUsed;
                timeUsed = timeUsed % 100 + (timeUsed/100)*60;
                answerMap.put(number, answerMap.getOrDefault(number, 0) + timeUsed);
            }
        }
        int[] answer = new int[answerMap.size()];
        Iterator<Integer> iter = answerMap.keySet().iterator();
        int[] keys = new int[answer.length];
        int ptr = 0;
        while(iter.hasNext())
            keys[ptr++] = iter.next();
        Arrays.sort(keys);
        // System.out.println(answerMap.toString());
        ptr = 0;
        for(int i : keys){
            int tmp = answerMap.get(i) - fees[0];
            if(tmp < 0)
                tmp = 0;
    //         int costTime = answerList.get(number) - fees[0];
    //         if(costTime < 0)
    //             costTime = 0;
    //         answer[idx++] = fees[1] + (int)(Math.ceil((double)costTime/fees[2]) * fees[3])   (int)(Math.ceil((double)costTime/fees[2]) * fees[3])
            answer[ptr++] = fees[1] + (int)(Math.ceil((double)tmp/fees[2]) * fees[3]);
        }
        return answer;
    }
}