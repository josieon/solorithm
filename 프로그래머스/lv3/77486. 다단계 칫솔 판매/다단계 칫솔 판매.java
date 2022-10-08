import java.util.*;
class Node{
    Node parent;
    ArrayList<Node> child;
    int money;
    public Node(Node parent){
        this.money = 0;
        this.parent = parent;
    }
    public void share(int amount){
        int mon = amount*100;
        this.money += Math.ceil(mon*0.9);
        mon *= 0.1;
        Node par = this.parent;
        while(par != null && mon != 0){
            par.money += Math.ceil((double)mon*0.9);
            mon /= 10;
            if(par.parent == null)
                par.money += mon;
            par = par.parent;
        }
    }
}
class Solution {
    public static HashMap<String, Node> mem = new HashMap();
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Node> mem = new HashMap();
        mem.put("center", new Node(null));
        for(int i = 0; i < enroll.length; i++){
            String who = referral[i];
            if(who.matches("-"))
                mem.put(enroll[i], new Node(mem.get("center")));
            else
                mem.put(enroll[i], new Node(mem.get(who)));
        }
        for(int i = 0; i < seller.length; i++){
            Node target = mem.get(seller[i]);
            target.share(amount[i]);
        }
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++){
            answer[i] = mem.get(enroll[i]).money;
        }
        return answer;
    }
}