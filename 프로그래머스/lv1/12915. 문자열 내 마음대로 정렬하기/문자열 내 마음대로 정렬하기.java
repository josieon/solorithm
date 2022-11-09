import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String e1, String e2){
                return e1.charAt(n)!=e2.charAt(n)? e1.charAt(n) - e2.charAt(n) : e1.compareTo(e2);
            }
        });
        return strings;
    }
}