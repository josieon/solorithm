class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i = 0 ; i < quiz.length; i++){
            String[] tmp = quiz[i].split(" ");
            switch(tmp[1]){
                case "+" :
                    if(tmp[4].matches(Integer.toString(Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[2]))))
                        answer[i] = "O";
                    else
                        answer[i] = "X";
                    break;
                case "-" :
                    if(tmp[4].matches(Integer.toString(Integer.parseInt(tmp[0]) - Integer.parseInt(tmp[2]))))
                        answer[i] = "O";
                    else
                        answer[i] = "X";
                    break;
            }
        }
        return answer;
    }
}