class Solution {
    public static int solution(String dirs) {
        boolean[][] vertical = new boolean[10][11];
        boolean[][] horizontal = new boolean[11][10];
        int x = 0, y = 0, answer = 0;
        for(char c : dirs.toCharArray()){
            switch(c){
                case 'U':
                    if(y < 5){
                        if(!vertical[++y+4][x+5]){
                            vertical[y+4][x+5] = true;
                            answer++;
                        }
                    }
                    break;
                case 'D':
                    if(y > -5){
                        if(!vertical[--y+5][x+5]){
                            vertical[y+5][x+5] = true;
                            answer++;
                        }
                    }
                    break;
                case 'L':
                    if(x > -5){
                        if(!horizontal[y+5][--x+5]){
                            horizontal[y+5][x+5] = true;
                            answer++;
                        }
                    }
                    break;
                case 'R':
                    if(x < 5){
                        if(!horizontal[y+5][++x+4]){
                            horizontal[y+5][x+4] = true;
                            answer++;
                        }
                    }
                    break;
            }
        }
        return answer;
    }
}