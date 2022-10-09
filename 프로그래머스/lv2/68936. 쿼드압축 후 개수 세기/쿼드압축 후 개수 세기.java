class Solution {
    static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        dp(0,0,arr.length, arr);
        return answer;
    }
    public static void dp(int startX, int startY, int size, int[][] arr){
        if(check(startX, startY, size, arr)){
            answer[arr[startX][startY]]++;
            return;
        }
        dp(startX, startY, size/2, arr);
        dp(startX+size/2, startY, size/2, arr);
        dp(startX, startY+size/2, size/2, arr);
        dp(startX+size/2, startY+size/2, size/2, arr);
    }
    public static boolean check(int x, int y, int size, int[][] arr){
        for(int i = x; i < x+size; i++)
            for(int j = y; j < y + size; j++)
                if(arr[i][j] != arr[x][y])
                    return false;
        return true;
    }
}