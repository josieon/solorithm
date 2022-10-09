import java.util.*;
class Solution {
        public static int solution(int[] citations){
        Arrays.sort(citations);
        int idx = citations.length - 1;
        for(int i = citations[citations.length - 1]; i >= 0; i--){
            while(idx >= 0 && citations[idx] >= i)
                idx--;
            if(citations.length - idx > i)
                return i;
        }
        return -1;
    }
}