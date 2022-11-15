import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int[] a = A.clone();
        Arrays.sort(A);
        Arrays.sort(B);
        int idxA = 0, idxB = 0;
        for(; idxB < B.length; idxB++){
            if(A[idxA] < B[idxB]){
                idxA++;
                continue;
            }
        }
        return idxA;
    }
}