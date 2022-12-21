import java.util.*;
class Solution {
    //다익스트라 문제
    ArrayList<ArrayList<Integer>> list = new ArrayList();
    public int solution(int n, int[][] edge) {
        for(int i = 0; i <= n; i++)
            list.add(new ArrayList());
        for(int[] cur : edge){
            list.get(cur[0]).add(cur[1]);
            list.get(cur[1]).add(cur[0]);
        }
        int[] distance = new int[n+1];
        int max = 0;
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int neighbor : list.get(cur)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    distance[neighbor] = distance[cur] + 1;
                    if(max < distance[neighbor])
                        max = distance[neighbor];
                }
            }
        }
        int answer = 0;
        for(int target : distance)
            if(max == target)
                answer++;
        // System.out.println(Arrays.toString(distance));
        return answer;
    }
}