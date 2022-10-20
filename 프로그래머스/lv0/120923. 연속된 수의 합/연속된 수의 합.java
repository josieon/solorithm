class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        if(num % 2 == 0){
            for(int i = 0, val = (total/num) - (num/2) + 1; i < num; i++, val++)
                answer[i] = val;
        }
        else{
            for(int i = 0, val = total/num - num/2; i < num; i++, val++)
                answer[i] = val;
        }
        return answer;
    }
}