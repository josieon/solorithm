import java.util.*;
class node{
    public int value;
    public int level;
    node(int value, int level){
        this.value = value;
        this.level = level;
    }
}
class Solution {
    static int count = 0;
    public int solution(int[] numbers, int target){
        Queue<node> q = new LinkedList();
        q.add(new node(0, 0));
        while(!q.isEmpty()){
            node tmp = q.poll();
            if(tmp.level != numbers.length){
                q.add(new node(tmp.value + numbers[tmp.level], tmp.level+1));
                q.add(new node(tmp.value - numbers[tmp.level], tmp.level+1));
            }
            else{
                if(tmp.value == target)
                    count++;
            }
        }
        return count;
    }
    // DFS
    // public int solution(int[] numbers, int target) {
    //     dfs(0, 0, numbers, target);
    //     return count;
    // }
    // public static void dfs(int idx, int sum, int[] numbers, int target){
    //     if(idx == numbers.length){
    //         if(sum == target)
    //             count++;
    //         return;
    //     }
    //     dfs(idx+1, sum + numbers[idx], numbers, target);
    //     dfs(idx+1, sum - numbers[idx], numbers, target);
    // }
}