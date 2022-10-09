class Solution {
    public int[] solution(int brown, int yellow) {
        int[] res = new int[2];
        for(int i = 1; i <= Math.sqrt(yellow); i++){
            if(yellow % i != 0)
                continue;
            res[1] = i + 2;
            res[0] = yellow / i + 2;
            if(res[1] * res[0] != yellow + brown)
                continue;
            break;
        }
        return res;
    }
}