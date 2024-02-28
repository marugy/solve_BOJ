class Solution {
    
    static int answer = 0;
    static boolean []visited = null;

    static void checkNetwork(int num, int[][]computers){
        for(int i=0;i<computers[num].length; i++){
            if(computers[num][i]==1 && !visited[i]){
                visited[i]=true;
                checkNetwork(i,computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for(int i=0;i<n; i++){
            if(!visited[i]){
                answer++;
                visited[i]=true;
                checkNetwork(i, computers);
            }
        }        
        return answer;
    }
}