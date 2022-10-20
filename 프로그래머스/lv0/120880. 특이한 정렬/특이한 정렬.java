import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        int down = 0, top = numlist.length - 1, mid = (top + down) / 2;
        Arrays.sort(numlist);
        while(down < top){
            if(numlist[mid] > n){
                top = mid - 1;
                mid = (top + down) / 2;
            }
            else if(numlist[mid] < n){
                down = mid + 1;
                mid = (top + down) / 2;
            }
            else
                break;
        }
        down = mid;
        top = mid + 1;
        int[] answer = new int[numlist.length];
        for(int i = 0; i < answer.length; i++){
            if(top >= answer.length){
                while(i < answer.length){
                    answer[i++] = numlist[down--];
                }
                return answer;
            }
            if(down < 0){
                while(i < answer.length)
                    answer[i++] = numlist[top++];
                return answer;
            }
            int dDown = Math.abs(n-numlist[down]);
            int dTop = Math.abs(n-numlist[top]);
            if(dDown < dTop){
                answer[i] = numlist[down--];
            }
            else
                answer[i] = numlist[top++];
        }
        return answer;
    }
}