class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int k : arr) answer+=k;
        return answer/arr.length;
    }
}