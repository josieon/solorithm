import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, HashMap<Integer, Integer>> hash = new HashMap();
        HashMap<String, Integer> playsTotal = new HashMap();
        for(int i = 0; i < plays.length; i++){
            playsTotal.put(genres[i], playsTotal.getOrDefault(genres[i], 0) + plays[i]);
            HashMap tmp = hash.getOrDefault(genres[i], new HashMap());
            tmp.put(i, plays[i]);
            hash.put(genres[i], tmp);
        }
        List<String> list = new LinkedList(playsTotal.keySet());
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String e1, String e2){
                return playsTotal.get(e2) - playsTotal.get(e1);
            }
        });
        List<Integer> ans = new LinkedList();
        for(String str : list){
            List<Integer> cur = new ArrayList(hash.get(str).keySet());
            Collections.sort(cur, new Comparator<Integer>(){
                @Override
                public int compare(Integer e1, Integer e2){
                    HashMap<Integer, Integer> genre = hash.get(str);
                    return genre.get(e2) - genre.get(e1);
                }
            });
            for(int i = 0; i < 2 && i < cur.size(); i++)
                ans.add(cur.get(i));
        }
        int[] answer = new int[ans.size()];
        for(int i = 0 ; i < answer.length; i++)
            answer[i] = ans.get(i);
        // System.out.println(ans.toString());
        return answer;
    }
}