class Solution {
    public static int answer = 0;
    public int solution(int[] nums) {
        doCombination(nums, 0, 3, 0);
        return answer;
    }
    public void doCombination(int[] nums, int sum, int r, int stage){
        if(r == 0){
            for(int i = 2; i <= Math.sqrt(sum); i++)
                if(sum % i == 0)
                    return;
            answer++;
            return;
        }
        else if(stage == nums.length)
            return;
        else{
            doCombination(nums, sum+nums[stage], r-1, stage+1);
            doCombination(nums, sum, r, stage+1);
        }
    }
}