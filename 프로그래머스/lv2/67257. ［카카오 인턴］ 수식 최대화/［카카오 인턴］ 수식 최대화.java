import java.util.*;
class Solution {
    public static List<String> operators;
    public static List<Long> operands;
    public static long answer = 0;
    public static long solution(String expression) {
        operands = new ArrayList();
        operators = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*'){
                operands.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
                operators.add(Character.toString(expression.charAt(i)));
            }
            else
                sb.append(expression.charAt(i));
        }
        operands.add(Long.parseLong(sb.toString()));
        permutation("*+-", 0);
        return answer;
    }
    public static void permutation(String operator, int start){
        if(start == 2){
            ArrayList<String> oper = new ArrayList(operators);
            ArrayList<Long> op = new ArrayList(operands);
            for(int i = 0; i < 3; i++){
                String opCur = String.valueOf(operator.charAt(i));
                while(op.size() != 0){
                    int idx = oper.indexOf(opCur);
                    if(idx == -1)
                        break;
                    else{
                        switch(opCur){
                            case "+":
                                op.add(idx, op.get(idx) + op.get(idx+1));
                                break;
                            case "*":
                                op.add(idx, op.get(idx) * op.get(idx+1));
                                break;
                            case "-":
                                op.add(idx, op.get(idx) - op.get(idx+1));
                                break;
                        }
                        op.remove(idx+1);
                        op.remove(idx+1);
                        oper.remove(idx);
                    }
                }
            }
            answer = Math.max(Math.abs(op.get(0)), answer);
            return;
        }
        else if(start == 0){
            permutation(operator, start+1);
            StringBuilder sb = new StringBuilder();
            sb.append(operator.charAt(1)).append(operator.charAt(0)).append(operator.charAt(2));
            permutation(sb.toString(), start+1);
            sb = new StringBuilder();
            sb.append(operator.charAt(2)).append(operator.charAt(0)).append(operator.charAt(1));
            permutation(sb.toString(), start+1);
        }
        else{
            permutation(operator, start+1);
            StringBuilder sb = new StringBuilder();
            sb.append(operator.charAt(0)).append(operator.charAt(2)).append(operator.charAt(1));
            permutation(sb.toString(), start+1);
        }
    }
}