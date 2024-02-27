class Solution {
    
    static int answer = 0;
    
    static void dfs(int[]numbers, int target, int n, int sum){
        if(n==numbers.length){
            if(sum==target)
                answer++;
            return;
        }
        dfs(numbers, target, n+1, sum+numbers[n]);
        dfs(numbers, target, n+1, sum-numbers[n]);
    }
    
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);
        return answer;
    }
}