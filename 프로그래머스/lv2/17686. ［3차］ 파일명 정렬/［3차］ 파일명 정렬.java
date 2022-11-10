import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String e1, String e2){
                String h1 = "", h2 = "", t1 = "", t2 = "";
                int n1 = 0, n2 = 0;
                outer1:
                for(int i = 0; i < e1.length(); i++){
                    if(Character.isDigit(e1.charAt(i))){
                        // System.out.println(e1 + "\t" + i);
                        h1 = e1.substring(0, i).toLowerCase();;
                        int j = i+1;
                        for(; j < e1.length(); j++){
                            if(!Character.isDigit(e1.charAt(j))){
                                n1 = Integer.parseInt(e1.substring(i, j));
                                t1 = e1.substring(j);
                                break outer1;
                            }
                        }
                        if(j == e1.length())
                            n1 = Integer.parseInt(e1.substring(i));
                        break;
                    }
                }
                outer2:
                for(int i = 0; i < e2.length(); i++){
                    if(Character.isDigit(e2.charAt(i))){
                        // System.out.println(e1 + "\t" + i);
                        h2 = e2.substring(0, i).toLowerCase();
                        int j = i + 1;
                        for(; j < e2.length(); j++){
                            if(!Character.isDigit(e2.charAt(j))){
                                n2 = Integer.parseInt(e2.substring(i, j));
                                t2 = e2.substring(j);
                                break outer2;
                            }
                        }
                        if(j == e2.length())
                            n2 = Integer.parseInt(e2.substring(i));
                        break;
                    }
                }
                if(h1.matches(h2)){
                    // System.out.println("e1:"+e1+"\te2:"+e2+"\th1:"+h1+"\th2:"+h2+"\tn1:"+n1+"\tn2:"+n2);
                    if(n1 == n2){
                        return 0;
                    }
                    else
                        return n1 - n2;
                }
                else{
                    return h1.compareTo(h2);
                }
            }
        });
        return files;
    }
}