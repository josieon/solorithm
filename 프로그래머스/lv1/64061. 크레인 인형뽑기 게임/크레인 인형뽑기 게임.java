import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        HashMap<Integer, Deque<Integer>> hash = new HashMap();
        for(int i = 0; i < board[0].length; i++)
            hash.put(i+1, new LinkedList());
        int answer = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 0)
                    continue;
                Deque<Integer> d = hash.get(j+1);
                // if(!d.isEmpty() && d.getLast() == board[i][j])
                //     d.pop();
                // else
                d.add(board[i][j]);
            }
        }
        Iterator<Integer> iter = hash.keySet().iterator();
        // while(iter.hasNext()){
        //     System.out.println(hash.get(iter.next()).toString());
        // }
        Stack<Integer> stk = new Stack();
        for(int i : moves){
            // System.out.println(stk.toString());
            Deque<Integer> tmp = hash.get(i);
            if(tmp.isEmpty())
                continue;
            int num = tmp.poll();
            if(!stk.isEmpty() && num == stk.peek()){
                stk.pop();
                answer++;
                while(stk.size() >= 2){
                    num = stk.pop();
                    if(num == stk.peek()){
                        stk.pop();
                        answer++;
                    }
                    else{
                        stk.add(num);
                        break;
                    }
                }
            }
            else
                stk.add(num);
        }
        iter = hash.keySet().iterator();
        // while(iter.hasNext()){
        //     System.out.println(hash.get(iter.next()).toString());
        // }
        return answer * 2;
    }
}