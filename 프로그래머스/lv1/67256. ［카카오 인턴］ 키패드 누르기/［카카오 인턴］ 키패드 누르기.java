class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] mid = {2, 5, 8, 0};
        String lef = "[1,4,7]", rig = "[3,6,9]";
        int[] l = {0, 3}, r = {2, 3};
        for(int num : numbers){
            String cur = Integer.toString(num);
            if(cur.matches(lef)){
                answer += "L";
                l[0] = 0;
                l[1] = num / 3;
            }
            else if(cur.matches(rig)){
                answer += "R";
                r[0] = 2;
                r[1] = num / 3 - 1;
            }
            else{
                int j = 0;
                for(; j < 4; j++)
                    if(mid[j] == num)
                        break;
                int disL = Math.abs(l[0] - 1) + Math.abs(l[1] - j);
                int disR = Math.abs(r[0] - 1) + Math.abs(r[1] - j);
                if((disL == disR && hand.matches("left")) || disL < disR){
                    answer += "L";
                    l[0] = 1;
                    l[1] = j;
                }
                else{
                    answer += "R";
                    r[0] = 1;
                    r[1] = j;
                }
            }
        }
        return answer;
    }
}