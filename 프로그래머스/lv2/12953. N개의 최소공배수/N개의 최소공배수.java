import java.util.*;
class Solution {
    public int solution(int[] arr) {
        while(arr.length > 1){
            int[] tmp = new int[arr.length - 1];
            for(int i = 0; i < tmp.length - 1; i++)
                tmp[i] = arr[i];
            int gcd = gcd(arr[arr.length - 1], arr[arr.length - 2]);
            tmp[tmp.length - 1] = arr[arr.length - 1] / gcd * arr[arr.length - 2];
            arr = tmp;
        }
        return arr[0];
    }
    public static int gcd(int A, int B){
        if(B == 0)
            return A;
        return gcd(B, A % B);
    }
}