import java.util.*;
class Solution {
    public static int solution(String str1, String str2){
        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        String check = "[A-Z]";

        for(int i = 0; i < str1.length() - 1; i++)
            if(str1.substring(i, i+1).matches(check) && str1.substring(i+1, i+2).matches(check))
                list1.add(str1.substring(i, i+2));
        for(int i = 0; i < str2.length() - 1; i++)
            if(str2.substring(i, i+1).matches(check) && str2.substring(i+1, i+2).matches(check))
                list2.add(str2.substring(i, i+2));
        
        double intersect = 0;
        if(list1.size() > list2.size()){
            LinkedList<String> tmp = list1;
            list1 = list2;
            list2 = tmp;
        }
        int l2Size = list2.size();
        if(l2Size == 0 && list1.size() == 0)
            return 65536;
        Iterator<String> iter1 = list1.iterator();
        while(iter1.hasNext()){
            String str = iter1.next();
            Iterator<String> iter2 = list2.iterator();
            while(iter2.hasNext()){
                if(iter2.next().equals(str)){
                    intersect++;
                    list2.remove(str);
                    break;
                }
            }
        }
        double union = list1.size() + l2Size - intersect;
        answer = (int)(65536 * (intersect / union));
        return answer;
    }
}