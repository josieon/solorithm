import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] man2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] man3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] ans = new int[3];
        for(int i = 0; i < answers.length; i++){
            if(answers[i]-1 == i % 5)
                ans[0]++;
            if(answers[i] == man2[i % man2.length])
                ans[1]++;
            if(answers[i] == man3[i % man3.length])
                ans[2]++;
        }
        int max = Arrays.stream(ans).max().getAsInt();
        ArrayList<Integer> a = new ArrayList();
        for(int i = 0; i < 3; i++)
            if(ans[i] == max)
                a.add(i+1);
        Iterator<Integer> iter = a.iterator();
        ans = new int[a.size()];
        int idx = 0;
        while(iter.hasNext())
            ans[idx++] = iter.next();
        return ans;
    }
}