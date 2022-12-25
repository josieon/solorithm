class Solution {
    public int solution(String t, String p) {
        int answer = 0, lenP = p.length();
        Long numP = Long.parseLong(p);
        for(int i = 0; i <= t.length() - lenP; i++){
            // System.out.println(t.substring(i, i+p.length()));
            Long cur = Long.parseLong(t.substring(i, i + lenP));
            // System.out.println(cur);
            if(cur <= numP)
                answer++;
        }
        return answer;
    }
}