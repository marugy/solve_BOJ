import java.util.Arrays;
class Solution {
    public int solution(int[] nums) {
        int answer = nums.length/2;
        int[] distArr = Arrays.stream(nums).distinct().toArray();
        if(distArr.length < nums.length/2)
            answer = distArr.length;
        return answer;
    }
}