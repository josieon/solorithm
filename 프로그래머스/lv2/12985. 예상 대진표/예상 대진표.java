class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int na = a;
        int nb = b;
        while(true){
            if(Math.abs(na - nb) == 1 && (na / 2) != (nb / 2))
                break;
            na = na % 2 == 1? na/2+1 : na/2;
            nb = nb % 2 == 1? nb/2+1 : nb/2;
            answer++;
        }
        return answer;
    }
}