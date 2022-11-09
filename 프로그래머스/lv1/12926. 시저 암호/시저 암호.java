class Solution {
    public String solution(String s, int n) {
        // 'a' = 97, 'A' = 65
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c != ' '){
                if(Character.isLowerCase(c)){
                    if(Character.isLowerCase(c+n-26))
                        sb.append(String.format("%c",c+n-26));
                    else
                        sb.append(String.format("%c",c+n));
                }
                else if(Character.isLetter(c+n-26))
                    sb.append(String.format("%c", c+n-26));
                else
                    sb.append(String.format("%c", c+n));
            }
            else
                sb.append(' ');
        }
        return sb.toString();
    }
}