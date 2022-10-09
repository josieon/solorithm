import java.util.*;
class Solution {
    public static int[] solution(String s){
        ArrayList<Integer> ans = new ArrayList<>();
        s = s.substring(2);
        s = s.substring(0, s.length() - 2).replace("},{", "-");
        String[] str = s.split("-");
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String e1, String e2){
                return Integer.compare(e1.length(), e2.length());
            }
        });
        for(String tmp : str){
            String[] arr = tmp.split(",");
            for(int i = 0; i < arr.length; i++){
                int n = Integer.parseInt(arr[i]);
                if(!ans.contains(n))
                    ans.add(n);
            }
        }
        int[] res = new int[ans.size()];
        int idx = 0;
        for(int i : ans){
            res[idx++] = i;
        }
        return res;
    }
}