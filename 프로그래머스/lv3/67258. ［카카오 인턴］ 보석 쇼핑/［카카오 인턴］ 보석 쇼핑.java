import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> gemKind = new HashSet();
        for(String gem : gems)
            gemKind.add(gem);
        HashMap<String, Integer> hash = new HashMap();
        int start = 0, end = 0;
        int left = 0, right = 0;
        int distance = Integer.MAX_VALUE;
        
        while(true){
            if(gemKind.size() == hash.size()){
                hash.put(gems[left], hash.get(gems[left])-1);
                if(hash.get(gems[left]) == 0)
                    hash.remove(gems[left]);
                left++;
            }
            else if(right == gems.length)
                break;
            else{
                hash.put(gems[right], hash.getOrDefault(gems[right], 0)+1);
                right++;
            }
            if(hash.size() == gemKind.size()){
                if(right-left < distance){
                    distance = right - left;
                    start = left + 1;
                    end = right;
                }
            }
        }
        return new int[]{start, end};
    }
}