class Solution {
    public static String solution(String new_id) {
        new_id = new_id.toLowerCase();
        String check = "[0-9a-z-_.]";
        String tmp = "";
        for(int i = 0; i < new_id.length(); i++){
            String dump = new_id.substring(i, i+1);
            if(dump.matches(check))
                tmp += dump;
        }
        // System.out.println(tmp);
        int len = tmp.length();
        do{
            len = tmp.length();
            tmp = tmp.replaceAll("\\.\\.", "\\.");
        }while(len != tmp.length());
        // System.out.println(tmp);
        if(tmp.length() > 0 && tmp.charAt(0) == '.')
            tmp = tmp.substring(1);
        // System.out.println(tmp);
        if(tmp.length() > 0 && tmp.charAt(tmp.length() - 1) == '.')
            tmp = tmp.substring(0, tmp.length()-1);
        // System.out.println(tmp);
        if(tmp.length() == 0)
            tmp += "a";
        // System.out.println(tmp);
        if(tmp.length() >= 16)
            tmp = tmp.substring(0, 15);
        // System.out.println(tmp);
        if(tmp.charAt(tmp.length() - 1) == '.')
            tmp = tmp.substring(0, tmp.length()-1);
        // System.out.println(tmp);
        if(tmp.length() <= 2){
            String last = tmp.substring(tmp.length() - 1, tmp.length());
            do{
                tmp += last;
            }while(tmp.length() < 3);
        }
        return tmp;
    }
}