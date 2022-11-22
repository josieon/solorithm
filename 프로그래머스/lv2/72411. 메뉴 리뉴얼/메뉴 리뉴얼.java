import java.util.*;
class Solution {
    public static HashMap<String, Integer> hash;
    public int max;
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList();
        for(int n : course){
            max = 0;
            hash = new HashMap();
            for(String s : orders){
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                combination(new String(chars), "", n, 0);
            }
            // System.out.println(hash.toString());
            if(max < 2)
                continue;
            Iterator<String> iter = hash.keySet().iterator();
            while(iter.hasNext()){
                String key = iter.next();
                if(hash.get(key) == max)
                    answer.add(key);
            }
        }
        String[] res = answer.toArray(new String[answer.size()]);
        Arrays.sort(res);
        // System.out.println(Arrays.toString(res));
        return res;
    }
    public void combination(String order, String cur, int r, int target){
        if(r == 0){
            int val = hash.getOrDefault(cur, 0) + 1;
            hash.put(cur, val);
            if(val > max)
                max = val;
            return;
        }
        else if(target == order.length())
            return;
        else{
            combination(order, cur+order.charAt(target), r-1, target+1);
            combination(order, cur, r, target+1);
        }
    }
}