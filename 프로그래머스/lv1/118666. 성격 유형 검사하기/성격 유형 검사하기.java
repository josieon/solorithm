import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<String, Integer> hash = new HashMap();
        hash.put("TR", 0);
        hash.put("RT", 0);
        hash.put("CF", 0);
        hash.put("FC", 0);
        hash.put("JM", 0);
        hash.put("MJ", 0);
        hash.put("AN", 0);
        hash.put("NA", 0);
        for(int i = 0 ; i < survey.length; i++){
            hash.put(survey[i], hash.getOrDefault(survey[i], 0) + choices[i] - 4);
        }
        String answer = "";
        if(hash.get("RT") > hash.get("TR"))
            answer += "T";
        else
            answer += "R";
        if(hash.get("CF") > hash.get("FC"))
            answer += "F";
        else
            answer += "C";
        if(hash.get("JM") > hash.get("MJ"))
            answer += "M";
        else
            answer += "J";
        if(hash.get("AN") > hash.get("NA"))
            answer += "N";
        else
            answer += "A";
        return answer;
    }
}