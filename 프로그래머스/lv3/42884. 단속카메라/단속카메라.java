import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] e1, int[] e2){
                if(e1[1] == e2[1])
                    return e1[0] - e2[0];
                return e1[1] - e2[1];
            }
        });
        System.out.println(Arrays.deepToString(routes));
        // HashSet<Integer> set = new HashSet();
        int bound = routes[0][1];
        int answer = 1;
        for(int[] cur : routes){
            if(cur[0] <= bound)
                continue;
            bound = cur[1];
            answer++;
        }
        return answer;
    }
}