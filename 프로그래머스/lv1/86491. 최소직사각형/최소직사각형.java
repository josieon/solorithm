import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int height = 0, width = 0;
        for(int[] tmp : sizes){
            Arrays.sort(tmp);
            if(tmp[0] > width)
                width = tmp[0];
            if(tmp[1] > height)
                height = tmp[1];
        }
        return width * height;
    }
}