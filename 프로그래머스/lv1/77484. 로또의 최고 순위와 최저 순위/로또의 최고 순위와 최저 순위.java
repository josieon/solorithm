class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int count = 0;
        int correct = 0;
        for(int tmp : lottos){
            if(tmp == 0){
                count++;
                continue;
            }
            for(int tmp2 : win_nums){
                if(tmp == tmp2){
                    correct++;
                    break;
                }
            }
        }
        return new int[] {rank[count+correct], rank[correct]};
    }
}